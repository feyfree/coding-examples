package com.feyfree.leetcode.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * p90 含有重复数字中生成子集
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(n, i, 0, new ArrayList<>(), result, nums, used);
        }
        return result;
    }

    private void dfs(int n, int k, int d, List<Integer> current, List<List<Integer>> result, int[] nums, boolean[] used) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = d; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (i > d && nums[i] == nums[i - 1] && !used[i]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            dfs(n, k, i + 1, current, result, nums, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
