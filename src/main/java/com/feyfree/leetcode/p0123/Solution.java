package com.feyfree.leetcode.p0123;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * @author leilei
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] right = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int result = 0;
        int min = prices[0];
        int leftProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            int rightProfit = (i == prices.length - 1) ? 0 : right[i + 1];
            leftProfit = Math.max(leftProfit, prices[i] - min);
            result = Math.max(result, leftProfit + rightProfit);
            min = Math.min(min, prices[i]);
        }
        return result;
    }

}