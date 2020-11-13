package com.feyfree.leetcode.p121;

/**
 * @author leilei
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minValue = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(prices[i], minValue);
        }
        return maxProfit;
    }
}