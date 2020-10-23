package com.feyfree.others;

/**
 * 单例模板
 *
 * @author leilei
 */
public class Singleton {

    /**
     * 只有在特别高的并发情况下 必须用volatile
     *
     * 其他情况下 其实加不加 都行
     */
    private static volatile Singleton singleton = null;

    Singleton() {
    }

    private static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
