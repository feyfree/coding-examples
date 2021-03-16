package com.feyfree.leetcode.p0312;

/**
 * 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。
 * 如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public int maxCoins(int[] nums) {
        final int n = nums.length;
        int[] values = new int[n + 2];
//        for (int i = 0; i < n; ++i) {
//            values[i + 1] = nums[i];
//        }
        System.arraycopy(nums, 0, values, 1, n);
        values[0] = values[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 1; l <= n; ++l) {
            for (int i = 1; i + l <= n + 1; ++i) {
                int j = i + l - 1;
                int best = 0;
                for (int k = i; k <= j; ++k) {
                    best = Math.max(best,
                            dp[i][k - 1] + values[i - 1] * values[k] * values[j + 1] + dp[k + 1][j]);
                }
                dp[i][j] = best;
            }
        }
        return dp[1][n];
    }
}
