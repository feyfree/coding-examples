package com.feyfree.leetcode.p0493;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/reverse-pairs/
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * fenwick tree 只是一个 sum 和, 不需要关心其他逻辑
 * 1. 维护一个值域
 * 2. 将值域进行映射 [value : index] 在 map 中用value 定位 index (线段索引)
 * 3. 迭代 nums 列表, 分别以 i 作为右端点 (相当于题目中的 j) 进行查找, i -> nums[i] 然后定位一下 目前在 2 * nums[i] 和 max_value 的 区间和
 * 4. 更新 fenwick tree
 *
 * @author leilei
 */
public class Solution {


    static class FenwickTree {

        /**
         * sum[i] 表示 原数组 [0, i-1] (闭区间) 的区间和
         */
        long[] sums;

        public FenwickTree(int n) {
            sums = new long[n + 1];
        }


        public void update(int i, int delta) {
            // 实际上是partial sum
            while (i < sums.length) {
                sums[i] += delta;
                i += i & -i;
            }
        }

        public long query(int i) {
            long sum = 0;
            // 2的幂次节点存储了该节点之前的sum
            while (i > 0) {
                sum += sums[i];
                i -= i & -i;
            }
            return sum;
        }


        public long getSum(int i, int j) {
            return query(j + 1) - query(i);
        }
    }

    public int reversePairs(int[] nums) {
        // 维护一个 nums[i] 和 2 * nums[i] 的有序集合
        TreeSet<Long> extended = new TreeSet<>();
        for (int num : nums) {
            extended.add((long) num);
            extended.add((long) num * 2);
        }
        // hash 构建 map 存储的是  扩展集合 中的 值
        Map<Long, Integer> map = new HashMap<>(extended.size());
        int index = 0;
        for (long value : extended) {
            map.put(value, index);
            index += 1;
        }
        int result = 0;
        FenwickTree tree = new FenwickTree(map.size());
        // 有序访问 实际上可以保证 是 i < j 的语义
        // 到 fenwick tree 这边就不要考虑 翻转对的 语义了, 只用考虑更新 sum 和 查找区间和
        for (int num : nums) {
            // 相当于 是 2 * nums[j]
            int left = map.get((long) num * 2);
            // 相当于是最大值 maxValue
            int right = map.size() - 1;
            // num 为右端点
            result += tree.getSum(left + 1, right);
            // 更新 num 为右端点的数量
            tree.update(map.get((long) num) + 1, 1);
        }
        return result;
    }

}
