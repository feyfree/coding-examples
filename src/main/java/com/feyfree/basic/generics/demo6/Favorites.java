package com.feyfree.basic.generics.demo6;

import java.util.HashMap;
import java.util.Map;

/**
 * 异构容器
 *
 * @author feyfree
 */
class Favorites {

    /**
     * 异构容器
     * <p>
     * 这个Favorites类型里面的键都不同类型的，这里将Favorites称为异构容器。
     * <p>
     * 它又两个局限性：
     * <p>
     * 1. 用户可以轻松地破坏Favorites的实例安全（可以用put方法中cast来避免）
     * 2. 它只能用于可具体化的类ing中（比如List这个类型你就不能传过去）
     */
    private Map<Class<?>, Object> favorites = new HashMap<>();

    /**
     * 存值
     *
     * @param type     这个是键，每个键的类型都是不同的
     * @param instance 这个就是值
     */
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }

        /**
         * 这里加上cast可以防止用户恶意改传类型
         */
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorites(Class<T> type) {
        /**
         * 这里的cast转换是安全的，因为放入的都是对应T的类型的值
         */
        return type.cast(favorites.get(type));
    }

}