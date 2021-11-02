package com.feyfree.leetcode.p0307.huahua;

/**
 * https://zxi.mytechroad.com/blog/data-structure/307-range-sum-query-mutable/
 * 树状数组
 *
 * @author huahua
 */
class NumArray {
    FenwickTree tree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            tree.update(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        tree.update(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return tree.query(j + 1) - tree.query(i);
    }

    static class FenwickTree {
        int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }


        public void update(int i, int delta) {
            // 实际上是partial sum
            while (i < sums.length) {
                sums[i] += delta;
                i += i & -i;
            }
        }

        public int query(int i) {
            int sum = 0;
            // 2的幂次节点存储了该节点之前的sum
            while (i > 0) {
                sum += sums[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}
