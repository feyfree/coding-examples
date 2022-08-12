package com.feyfree.leetcode.p0454;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/4sum-ii/
 *
 * @author leilei
 */
class Solution {
    private final Map<Integer, Integer> a = new HashMap<>();

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        calculateDualSum(nums1, nums2, a);
        for (int k : nums3) {
            for (int i : nums4) {
                result += a.getOrDefault(-(k + i), 0);
            }
        }
        return result;
    }

    private void calculateDualSum(int[] nums1, int[] nums2, Map<Integer, Integer> a) {
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                a.put(sum, a.getOrDefault(sum, 0) + 1);
            }
        }
    }
}
