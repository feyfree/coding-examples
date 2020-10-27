package com.feyfree.design.singleton;

/**
 * 资源， 具体可以是数据库连接， 网络连接等等
 */
class Resource {
}

/**
 * 枚举单例模式
 *
 * @author leilei
 */
public enum EnumSingleton {
    /**
     * 具体使用
     */
    INSTANCE;
    private Resource instance;

    EnumSingleton() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }
}