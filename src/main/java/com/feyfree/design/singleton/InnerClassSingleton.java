package com.feyfree.design.singleton;

/**
 * 内部静态类
 *
 * @author leilei
 */
public class InnerClassSingleton {

    private static class SingletonHolder {
        public static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
    }

    public static InnerClassSingleton newInstance() {
        return SingletonHolder.instance;
    }
}
