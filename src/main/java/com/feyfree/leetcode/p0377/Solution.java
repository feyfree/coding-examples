package com.feyfree.leetcode.p0377;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leilei
 */
class Solution {

    private int result;

    public int combinationSum4(int[] nums, int target) {
        result = 0;
        Arrays.sort(nums);
        // dfs 搜索
        dfs(nums, 0, target);
        return result;
    }


    private void dfs(int[] nums, int current, int target) {
        if (current == target) {
            result += 1;
        } else if (current < target) {
            for (int num : nums) {
                dfs(nums, current + num, target);
            }
        }
    }
}
