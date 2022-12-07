package com.feyfree.leetcode.p0460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 最不经常使用
 *
 * @author leilei
 */
public class LFUCache {

    /**
     * kv 映射
     */
    private final Map<Integer, Integer> kvMap;

    /**
     * key 和 频率映射
     */
    private final Map<Integer, Integer> kfMap;

    /**
     * 频率和 相同频率的key 映射
     */
    private final Map<Integer, LinkedHashSet<Integer>> fkMap;

    /**
     * 缓存容量
     */
    private final int capacity;

    /**
     * 最小频率
     */
    private int minFrequency;

    public LFUCache(int capacity) {
        this.kvMap = new HashMap<>();
        this.kfMap = new HashMap<>();
        this.fkMap = new HashMap<>();
        this.capacity = capacity;
        this.minFrequency = 0;
    }


    public int get(int key) {
        Integer val = kvMap.get(key);
        if (val == null) {
            return -1;
        }
        increaseFrequency(key);
        return val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (kvMap.containsKey(key)) {
            kvMap.put(key, value);
            // 更新频率
            increaseFrequency(key);
            return;
        }
        if (kvMap.size() >= this.capacity) {
            removeMinFrequency();
        }
        kvMap.put(key, value);
        kfMap.put(key, 1);
        fkMap.putIfAbsent(1, new LinkedHashSet<>());
        fkMap.get(1).add(key);
        this.minFrequency = 1;
    }


    private void removeMinFrequency() {
        LinkedHashSet<Integer> minSet = fkMap.get(this.minFrequency);
        Integer firstKey = minSet.iterator().next();
        minSet.remove(firstKey);
        if (minSet.isEmpty()) {
            fkMap.remove(this.minFrequency);
        }
        kvMap.remove(firstKey);
        kfMap.remove(firstKey);
    }


    private void increaseFrequency(int key) {
        Integer pf = kfMap.get(key);
        // 更新频率表
        kfMap.put(key, pf + 1);
        // 更新 新的频率映射集合
        fkMap.putIfAbsent(pf + 1, new LinkedHashSet<>());
        fkMap.get(pf + 1).add(key);
        // 删除 老的频率映射集合
        fkMap.get(pf).remove(key);
        if (fkMap.get(pf).isEmpty()) {
            fkMap.remove(pf);
            // 如果 pf == minF
            if (pf == this.minFrequency) {
                this.minFrequency++;
            }
        }
    }
}
