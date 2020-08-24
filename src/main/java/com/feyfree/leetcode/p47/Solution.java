package com.feyfree.leetcode.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * permutations-ii
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 每一层搜索 重复数字只能遍历一遍
 *
 * @author leilei
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        dfs(nums, cur, used, result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> result) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // Important!!! same number can be only used once at each depth
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            cur.add(nums[i]);
            dfs(nums, cur, used, result);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1,  2, 3};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }


}
