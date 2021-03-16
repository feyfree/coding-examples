package com.feyfree.leetcode.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和解法
 * <p>
 * 给定一个包含n 个整数的数组nums和一个目标值target，
 * 判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        // 数组排序
        Arrays.sort(nums);
        Integer compareValueA = null;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (compareValueA != null && compareValueA == nums[i]) {
                continue;
            }
            Integer compareValueB = null;
            for (int j = i + 1; j < nums.length; j++) {
                if (compareValueB != null && compareValueB == nums[j]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                Integer compareValueC = null;
                while (start < end) {
                    if (compareValueC != null && nums[start] == compareValueC) {
                        start++;
                        continue;
                    }
                    int remaining = nums[j] + nums[i] + nums[start] + nums[end] - target;
                    if (remaining == 0) {
                        List<Integer> temp = new ArrayList<>(4);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        compareValueC = nums[start];
                        compareValueB = nums[j];
                        compareValueA = nums[i];
                        start++;
                    } else if (remaining > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}
