package com.feyfree.design.singleton;

/**
 * 线程单例实现(ThreadLocal)
 *
 * @author leilei
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL_INSTANCE = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL_INSTANCE.get();
    }
}
