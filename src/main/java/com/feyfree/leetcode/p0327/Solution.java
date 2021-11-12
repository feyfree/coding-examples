package com.feyfree.leetcode.p0327;

/**
 * https://leetcode-cn.com/problems/count-of-range-sum/
 * 327. 区间和的个数
 * <p>
 * n平方的时间复杂度-超时
 *
 * @author leilei
 */
public class Solution {

    static class FenwickTree {
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

    public int countRangeSum(int[] nums, int lower, int upper) {
        FenwickTree tree = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tree.update(i + 1, nums[i]);
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum = tree.query(j + 1) - tree.query(i);
                if (sum >= lower && sum <= upper) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 5, -1};
        FenwickTree tree = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tree.update(i + 1, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum = tree.getSum(i, j);
                System.out.println(sum);
            }
        }
    }
}
