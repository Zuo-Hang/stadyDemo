package com.example.demo.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/09/03/10:51
 * @Description:
 */
public class ExecutorsDemo {
    public static void main(String[] args) {

        /** 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。*/
        /**
         *  创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会
         * 有一个新的线程来替代它。
         *  此线程池保证所有任务的执行顺序，按照任务的提交顺序(FIFO, LIFO, 优先级)执行。
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        /**
         * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
         * 可控制线程最大并发数，超出的线程会在队列中等待
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        /** 主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。 */
        /**
         * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
         * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
         * 此线程池不会对线程池大小做限制
         * 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        /**
         * 创建一个定时线程池，支持定时及周期性任务执行
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        /**
         * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，
         * 规避资源耗尽的风险。
         */
        /**
         * Executor接口中只声明了一个方法就是:void execute(Runnable command);这也是最核心的一个方法
         *
         *ExecutorService继承自Executor在其中扩充了一些对线程池操作的方法。
         * （关闭（两种）、判断是否关闭，终止、并将execute扩展为submit、invokeAll、invokeAny（单个、多个））
         *
         * AbstractExecutorService 到抽象类啦
         * 将继承来的一些方法进行实现，比如submit、invokeAll、invokeAny，
         * 其中submit做了返回值，但是核心还是调用了顶层接口中的executor，但executor并未实现，所以就只能是抽象类啦
         *
         * ThreadPoolExecutor 到实现类啦
         *
         */
    }

    private static ThreadFactory namedFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedFactory, new ThreadPoolExecutor.AbortPolicy());

//    public static void main(String[] args) {
////
////        for (int i = 0; i < Integer.MAX_VALUE; i++) {
////            //pool.execute(new SubThread());
////        }
//    }

}
