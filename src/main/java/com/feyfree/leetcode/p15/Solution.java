package com.feyfree.leetcode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 3sum
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // input 数组小于 3 返回
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        // 数组排序
        Arrays.sort(nums);
        Integer compareValue = null;
        List<List<Integer>> result = new ArrayList<>();
        // lastPointer 记录的是上一次的有效组合的最小值, 重复的nums[i]  不考虑直接continue
        for (int i = 0; i < nums.length; i++) {
            int cal = nums[i];
            if (compareValue != null && cal == compareValue) {
                continue;
            }
            if (i > nums.length - 3) {
                continue;
            }
            // 从剩余的数组中找到两数字之和
            Integer innerCompareValue = null;
            for (int j = i + 1; j < nums.length; j++) {
                // 剩余数组 定位和为 -cal 的组合
                if (innerCompareValue != null && innerCompareValue == nums[j]) {
                    continue;
                }
                int leftValue = -cal - nums[j];
                // 从剩下的数组中找到leftValue 二分查找
                boolean find = findValue(nums, j + 1, leftValue);
                if (find) {
                    // 构建列表到
                    List<Integer> item = new ArrayList<>(3);
                    item.add(cal);
                    item.add(nums[j]);
                    item.add(leftValue);
                    result.add(item);
                    compareValue = cal;
                    innerCompareValue = nums[j];
                }
            }
        }
        return result;
    }

    public boolean findValue(int[] nums, int low, int targetValue) {
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (targetValue < nums[mid]) {
                high = mid - 1;
            } else if (targetValue == nums[mid]) {
                return true;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}