package com.feyfree.leetcode.p0324;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/wiggle-sort-ii/
 * 324. 摆动排序 II
 *
 * @author leilei
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int[] replica = Arrays.copyOf(nums, nums.length);
        Arrays.sort(replica);
        int si = (nums.length + 1) / 2 - 1;
        int li = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = (i % 2 == 0) ? replica[si--] : replica[li--];
        }
    }


}
