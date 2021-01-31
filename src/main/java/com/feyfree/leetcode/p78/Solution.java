package com.feyfree.leetcode.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集的集合
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 子集实际上就是  组合的集合
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            dfs(n, i, 0, new ArrayList<>(), result, nums);
        }
        return result;
    }

    private void dfs(int n, int k, int d, List<Integer> current, List<List<Integer>> result, int[] nums) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = d; i < n; i++) {
            current.add(nums[i]);
            dfs(n, k, i + 1, current, result, nums);
            current.remove(current.size() - 1);
        }
    }
}