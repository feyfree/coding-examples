package com.feyfree.leetcode.p0220;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 *
 * @author leilei
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = s.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            s.add((long) nums[i]);
            if (i >= k) {
                s.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

