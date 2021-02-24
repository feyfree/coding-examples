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
        for (int i = 0; i < n; i++) {
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
            if (i > d && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            dfs(n, k, i + 1, current, result, nums);
            current.remove(current.size() - 1);
        }
    }
}
