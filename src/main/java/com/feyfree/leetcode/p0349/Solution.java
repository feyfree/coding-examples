package com.feyfree.leetcode.p0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 349. 两个数组的交集
 *
 * @author leilei
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        return Arrays.stream(nums2).filter(set1::contains).distinct().toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
