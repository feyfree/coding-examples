package com.feyfree.others;

/**
 * 单例模板
 *
 * @author leilei
 */
public class Singleton {

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
