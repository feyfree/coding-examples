package com.feyfree.leetcode.p47;

import java.util.ArrayList;
import java.util.List;

/**
 * permutations-ii
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * @author leilei
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, 0, nums.length, used, new ArrayList<>(), result);
        return result;
    }

    /**
     * dfs 搜索排列
     *
     * @param nums    输入数组
     * @param d       当前递归深度
     * @param n       目标递归深度
     * @param used    使用标记
     * @param current 当前排列
     * @param result  结果
     */
    private void permute(int[] nums, int d, int n, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (d == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            permute(nums, d + 1, n, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }


}
