package com.feyfree.leetcode.p0380;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 *
 * @author leilei
 */
class RandomizedSet {

    Map<Integer, Integer> map;

    List<Integer> values;

    Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 置换, 将当前的移除的换到最后, 然后移除尾部
        Integer current = map.get(val);
        Integer lastVal = values.get(values.size() - 1);
        values.set(current, lastVal);
        map.put(lastVal, current);
        values.remove(values.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}