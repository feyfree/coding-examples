package com.feyfree.leetcode.p0135;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * https://leetcode-cn.com/problems/candy/
 *
 * @author leilei
 */
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        // 从左往右
        // 从右往左
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }
        return Arrays.stream(ans).sum();
    }
}
