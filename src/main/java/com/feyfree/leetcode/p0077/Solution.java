package com.feyfree.leetcode.p0077;

import java.util.ArrayList;
import java.util.List;

/**
 * p77 组合的问题
 *
 * @author leilei
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>(), result);
        return result;
    }


    private void dfs(int n, int k, int d, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = d; i < n; i++) {
            current.add(i + 1);
            dfs(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(3, 2);
        System.out.println(result);
    }
}