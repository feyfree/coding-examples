package com.feyfree.leetcode.p15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author leilei
 */
public class AdvancedSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        // input 数组小于 3 返回
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        // 数组排序
        Arrays.sort(nums);
        Integer compareValue = null;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (compareValue != null && compareValue == nums[i]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            Integer marked = null;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (marked != null && nums[start] == marked) {
                    continue;
                }
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>(3);
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    marked = nums[start];
                    compareValue = nums[i];
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
