package com.feyfree.leetcode.p0134;

import java.util.Arrays;

/**
 * 134. 加油站
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @author leilei
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 剪枝
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        if (totalCost > totalGas) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            int val = dfs(i, gas, cost, 0, i);
            if (val == 0) {
                return i;
            }
        }
        return -1;
    }


    private int dfs(int current, int[] gas, int[] cost, int remaining, int init) {
        if (remaining < 0) {
            return -1;
        }
        if (current == init + gas.length - 1) {
            return 0;
        }
        int index = current > gas.length - 1 ? current - gas.length : current;
        return dfs(current + 1, gas, cost, remaining + gas[index] - cost[index], init);
    }
}