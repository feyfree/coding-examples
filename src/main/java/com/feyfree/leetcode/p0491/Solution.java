package com.feyfree.leetcode.p0491;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * @author leilei
 */
class Solution {
    List<Integer> current = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        // Q: 为什么这边不需要对start 进行 for loop 搜索
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    /**
     * dfs 搜索
     * <p>
     * Tips:
     * 1. 如果 start == last 只能将 start 加入current 搜索，并向后推
     * 2. 如果 start > last, 一种是添加到 current 搜索并向后推， 一种是不加入current， 直接向后推
     * 3. 如果 start < last, 只能直接向后推
     *
     * @param start 搜索起点
     * @param last  current 最后一个值
     * @param nums  搜索数组
     */
    public void dfs(int start, int last, int[] nums) {
        if (start == nums.length) {
            if (current.size() > 1) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        // A1: 如果 start 满足 递增, current 添加 start 并往后搜索
        if (nums[start] >= last) {
            current.add(nums[start]);
            dfs(start + 1, nums[start], nums);
            current.remove(current.size() - 1);
        }

        // A2: 如果 start 不和上一次相等
        if (nums[start] > last || nums[start] < last) {
            dfs(start + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 6, 7, 7};
        System.out.println(JSONObject.toJSONString(solution.findSubsequences(nums)));
    }
}

