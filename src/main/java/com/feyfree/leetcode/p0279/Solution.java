package com.feyfree.leetcode.p0279;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 *
 * @author leilei
 */
public class Solution {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                count[i] = Math.min(count[i - j * j] + 1, count[i]);
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(13));

    }
}
