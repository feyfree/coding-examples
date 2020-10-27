package com.feyfree.design.singleton;

/**
 * 饿汉
 *
 * @author leilei
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton newInstance() {
        return instance;
    }
}
