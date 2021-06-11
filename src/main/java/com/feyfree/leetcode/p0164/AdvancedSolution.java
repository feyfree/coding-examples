package com.feyfree.leetcode.p0164;

import java.util.Arrays;

/**
 * @author feyfree
 */
public class AdvancedSolution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        // 找到最大和最小值
        int[] result = findMinAndMaxVal(nums);
        int min = result[0];
        int max = result[1];
        int range = max - min;
        int binSize = range / n + 1;
        int[] minVal = new int[n];
        int[] maxVal = new int[n];
        for (int i = 0; i < n; i++) {
            minVal[i] = Integer.MAX_VALUE;
            maxVal[i] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            int index = (num - min) / binSize;
            minVal[index] = Math.min(minVal[index], num);
            maxVal[index] = Math.max(maxVal[index], num);
        }
        int maxGap = 0;
        int preMax = maxVal[0];
        for (int i = 1; i < n; i++) {
            if (minVal[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, minVal[i] - preMax);
                preMax = maxVal[i];
            }
        }
        return maxGap;
    }

    private int[] findMinAndMaxVal(int[] nums) {
        int[] result = new int[2];
        result[0] = nums[0];
        result[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[0] = Math.min(result[0], nums[i]);
            result[1] = Math.max(result[1], nums[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        AdvancedSolution solution = new AdvancedSolution();
        int[] nums = {1, 2, -1, 9};
        System.out.println(solution.maximumGap(nums));
    }

}
