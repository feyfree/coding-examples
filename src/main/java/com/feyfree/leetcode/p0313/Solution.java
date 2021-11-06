package com.feyfree.leetcode.p0313;

import java.util.*;

/**
 * 313. 超级丑数
 * https://leetcode-cn.com/problems/super-ugly-number/
 * <p>
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int[] count = new int[primes.length];
        Arrays.fill(count, 1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < count.length; j++) {
                int cal = dp[count[j]] * primes[j];
                dp[i] = Math.min(cal, dp[i]);
            }
            // 这地方要小心, 可能会出现 2 * 3, 3 * 2 的时候
            for (int j = 0; j < count.length; j++) {
                if (dp[i] == dp[count[j]] * primes[j]) {
                    count[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prime = new int[]{2, 3, 5};
        int n = 10;
        System.out.println(solution.nthSuperUglyNumber(n, prime));
    }
}
