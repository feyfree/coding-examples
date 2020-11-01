package com.feyfree.basic.generics.demo6;

import java.util.HashMap;
import java.util.Map;

class Favorites {
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