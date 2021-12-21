package com.feyfree.leetcode.p0381;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 本解法使用的是双向mapping -> 可以减少边缘判断
 * 当然也可以不用双向mapping
 *
 * @author leilei
 */
class RandomizedCollection {
    static class Entry {
        public int value;
        public int index;

        public Entry(int val, int idx) {
            value = val;
            index = idx;
        }
    }

    private final Map<Integer, List<Integer>> m;
    private final List<Entry> vals;
    private final Random rand;


    public RandomizedCollection() {
        this.m = new HashMap<>();
        this.vals = new ArrayList<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        List<Integer> l = m.getOrDefault(val, new ArrayList<>());
        l.add(this.vals.size());
        m.put(val, l);
        this.vals.add(new Entry(val, l.size() - 1));
        return l.size() == 1;
    }


    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }

        // val 对应的 数组容器中 的索引列表
        List<Integer> l = m.get(val);
        // 需要移除的索引位置
        int indexToEvict = l.get(l.size() - 1);
        // 数组容器尾部位置
        Entry lastEntry = vals.get(vals.size() - 1);

        // 数组容器尾部所在的值, 更新其map中索引数组
        // 这一步相当于是   通过数组容器中的entry.index 去更新 map.val => 对应的索引数组 中 的所在索引对应 值
        // 这个也是 O(1) 的时间复杂度
        m.get(lastEntry.value).set(lastEntry.index, indexToEvict);

        // 尾部置换
        vals.set(indexToEvict, lastEntry);

        // 清除尾部
        vals.remove(vals.size() - 1);
        l.remove(l.size() - 1);
        // 如果删没了, 就没必要保留 map 中 key = val 的项了
        if (l.size() == 0) {
            m.remove(val);
        }
        return true;
    }


    public int getRandom() {
        return vals.get(rand.nextInt(vals.size())).value;
    }
}
