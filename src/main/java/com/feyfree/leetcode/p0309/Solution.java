package com.feyfree.leetcode.p0309;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author leilei
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int prev = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prev);
        }
        return Math.max(rest, sold);
    }
}
