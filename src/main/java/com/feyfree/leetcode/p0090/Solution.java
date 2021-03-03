package com.feyfree.leetcode.p0090;

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
        dfs(n, 0, new ArrayList<>(), result, nums);
        return result;
    }

    private void dfs(int n, int d, List<Integer> current, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(current));
        if (current.size() == n) {
            return;
        }
        for (int i = d; i < n; i++) {
            // 避免重复的方法 - 相同深度 相同起点, 只需要搜索一次
            if (i > d && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            dfs(n, i + 1, current, result, nums);
            current.remove(current.size() - 1);
        }
    }
}
