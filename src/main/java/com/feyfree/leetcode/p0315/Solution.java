package com.feyfree.leetcode.p0315;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * 315. 计算右侧小于当前元素的个数
 * <p>
 * 给你`一个整数数组 nums ，按要求返回一个新数组counts 。
 * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量
 * <p>
 * raw:  5, 2, 6, 1
 * sort: 1, 2, 5, 6
 * reverse: 1, 6, 2, 5
 * rank: 1, 4, 2, 3
 *
 * @author leilei
 */
public class Solution {
    private static int lowBit(int x) {
        return x & (-x);
    }

    static class FenwickTree {
        private final int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowBit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowBit(i);
            }
            return sum;
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sorted.length; ++i) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                ranks.put(sorted[i], ++rank);
            }
        }

        FenwickTree tree = new FenwickTree(ranks.size());
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            //
            ans.add(tree.query(ranks.get(nums[i]) - 1));
            tree.update(ranks.get(nums[i]), 1);
        }

        Collections.reverse(ans);
        return ans;
    }
}