package com.feyfree.leetcode.p0395;

import java.util.Arrays;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * <p>
 * fenwick tree 的解法
 * prefix sum 解法 这种解法会超时
 *
 * @author leilei
 */
public class Solution {

    static class FenwickTree {
        long[][] sums;

        public FenwickTree(int n) {
            sums = new long[n + 1][26];
        }


        public void update(int i, char delta) {
            // 实际上是partial sum
            while (i < sums.length) {
                sums[i][delta - 'a'] += 1;
                i += i & -i;
            }
        }

        public long[] query(int i) {
            long[] sum = new long[26];
            // 2的幂次节点存储了该节点之前的sum
            while (i > 0) {
                for (int j = 0; j < 26; j++) {
                    sum[j] += sums[i][j];
                }
                i -= i & -i;
            }
            return sum;
        }

        public long[] getSum(int i, int j) {
            long[] result = new long[26];
            long[] end = query(j + 1);
            long[] start = query(i);
            for (int k = 0; k < 26; k++) {
                result[k] = end[k] - start[k];
            }
            return result;
        }
    }

    public int longestSubstring(String s, int k) {
        int n = s.length();
        FenwickTree tree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            tree.update(i + 1, s.charAt(i));
        }
        int maxLen = 0;
        for (int j = k - 1; j < n; j++) {
            for (int i = 0; i <= j - k + 1; i++) {
                long[] count = tree.getSum(i, j);
                System.out.println(Arrays.toString(count));
                if (isValid(count, k)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(long[] count, int k) {
        for (long l : count) {
            if (l > 0 && l < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestSubstring("aaabb", 3);
    }
}
