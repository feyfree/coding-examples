package com.feyfree.design.singleton;

/**
 * 懒汉
 *
 * @author leilei
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton newInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
