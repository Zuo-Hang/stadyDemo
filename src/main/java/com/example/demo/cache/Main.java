package com.example.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/15/20:32
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个带有RemovalListener监听的缓存
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder()
                .removalListener(removalNotification -> {
                    String tips = String.format("key=%s,value=%s,reason=%s",
                            removalNotification.getKey(),
                            removalNotification.getValue(),
                            removalNotification.getCause());
                    System.out.println(tips);
                })
                .build();
        cache.put(1, 1);
        // 手动清除
        cache.invalidate(1);
        //System.out.println(cache.getIfPresent(1));
    }
}
