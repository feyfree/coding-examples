package com.feyfree.leetcode.p89;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划解法
 *
 * @author leilei
 */
public class DpSolution {
    public List<Integer> grayCode(int n) {
        List<List<Integer>> dp = new ArrayList<>(n + 1);
        List<Integer> first = new ArrayList<>();
        first.add(0);
        dp.add(first);
        for (int i = 1; i <= n; i++) {
            dp.add(dp.get(i - 1));
            for (int j = dp.get(i - 1).size() - 1; j >= 0; j--) {
                dp.get(i).add(dp.get(i - 1).get(j) | (1 << (i - 1)));
            }
        }
        return dp.get(n);
    }
}
