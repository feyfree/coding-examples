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
        // 可以增加 避免反射调用
        if (SingletonHolder.instance != null) {
            throw new RuntimeException("Not allowed create multi instance");
        }
    }

    public static InnerClassSingleton newInstance() {
        return SingletonHolder.instance;
    }
}
