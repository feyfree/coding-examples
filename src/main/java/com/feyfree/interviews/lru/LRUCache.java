package com.feyfree.interviews.lru;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * java 实现 lru 算法
 * 1. 维护一个双向链表
 * 2. moveToHead 操作
 * 3. removeTail 操作
 *
 * @author Leilei
 * @see com.feyfree.leetcode.p0146.LRUCache
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

