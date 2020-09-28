package com.example.demo.cache;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/17/10:51
 * @Description: 软引用缓存，解决不存在缓存中间件情况下，使用JVM缓存导致OOM
 */
public class SoftReferenceCache<K,V>{

    //默认最大值
    private static final int DEFAULT_MAP_SIZE = 1024;

    //自身引用
    private static SoftReferenceCache softReferenceCache = new SoftReferenceCache();

    //真正存储的位置
    private Map<K, CacheReference<K,V>> softReferenceMap = new HashMap<>(DEFAULT_MAP_SIZE);

    //引用队列，注册的引用对象被
    //在检测到适当的可达性更改后进行垃圾回收
    private final ReferenceQueue<V> referenceQueue;

    private final ObjectNotFoundHandler<K,V> objectNotFoundHandler;

    /**
     * 构造方法
     * @param handler
     */
    public SoftReferenceCache(ObjectNotFoundHandler<K, V> handler){
        this.referenceQueue = new ReferenceQueue<V>();
        this.objectNotFoundHandler = handler == null ? new DefaultObjectNotFoundHandler<K,V>() : handler;
    }

    /**
     * 无参构造方法
     */
    public SoftReferenceCache() {
        this(null);
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static SoftReferenceCache newInstance(){
        return softReferenceCache;
    }

    /**
     * 根据key清除对应的缓存
     * @param key
     */
    public final void clearSoftReference(K key){
        //判断key对应软引用的对象是否被回收
        if(this.softReferenceMap.containsKey(key) && this.softReferenceMap.get(key).get() == null){
            this.softReferenceMap.remove(key);
        }
        V object = null;
        //如果当前Key对应的软引用的对象被回收则移除该Key
        Reference<? extends V> reference = null;
        while ((reference = this.referenceQueue.poll()) != null ){
            object = reference.get();
            if(object == null){
                this.softReferenceMap.remove(((CacheReference<K, V>) reference).getKey());
            }
        }
    }

    /**
     * 将需要缓存的数据放入缓存池
     * @param key
     * @param reference
     */
    public final void putSoftReference(K key,V reference){
        clearSoftReference(key);
        if(!this.softReferenceMap.containsKey(key) || this.softReferenceMap.get(key).get() != null){
            this.softReferenceMap.put(key,new CacheReference<K, V>(key,reference,this.referenceQueue));
        }
    }

    /**
     * 根据key获取缓存池中的对象
     * @param key
     * @return
     */
    public final V getSoftReference(K key){
        V object = null;
        if(this.softReferenceMap.containsKey(key)){
            object = this.softReferenceMap.get(key).get();
        }
        if(object == null){
            //软引用指向的对象被回收,并缓存该软引用
            object = this.objectNotFoundHandler.queryValueAndCache();
            this.putSoftReference(key,object);
        }
        return object;
    }

    /**
     * 清空所有缓存
     */
    public final void clearAllObject() {
        this.softReferenceMap.clear();
    }

    /**
     * 是否存在key对应的对象
     * @param key
     * @return
     */
    public final boolean containsKey(Object key) {
        return softReferenceMap.containsKey(key);
    }

    /**
     * 缓存应用类，继承软引用
     * @param <K>
     * @param <V>
     */
    private static class CacheReference<K,V> extends SoftReference<V> {

        private final K key;

        public CacheReference(K key, V reference, ReferenceQueue<V> queue) {
            super(reference,queue);
            this.key = key;
        }

        public K getKey(){
            return this.key;
        }
    }

    /**
     * 缓存取不到时的处理器接口
     * @param <K>
     * @param <V>
     */
    public interface ObjectNotFoundHandler<K,V>{
        V queryValueAndCache();
    }


    /**
     * 缓存中取不到时的处理器默认实现类
     */
    private static class DefaultObjectNotFoundHandler<K,V> implements ObjectNotFoundHandler<K,V>{

        @Override
        public V queryValueAndCache() {
            //后面根据实际业务场景需要实现
            return null;
        }

    }

}
