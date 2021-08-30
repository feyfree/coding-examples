package com.feyfree.leetcode.p0216;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 216. 组合总和 III
 *
 * @author leilei
 */
public class Solution {

    private int[] nums;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        dfs(1, k, n, new ArrayList<>(), result);
        return result;
    }


    private void dfs(int d, int k, int n, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            if (n == 0) {
                result.add(current);
                return;
            }
        }
        for (int i = d; i <= 9; i++) {
            if (i > n) {
                return;
            }
            current.add(i);
            dfs(i + 1, k - 1, n - i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
