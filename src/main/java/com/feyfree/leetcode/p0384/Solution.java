package com.feyfree.leetcode.p0384;

import java.util.Random;

class Solution {
    int[] nums;
    int[] raw;

    public Solution(int[] nums) {
        this.nums = nums;
        this.raw = new int[nums.length];
        System.arraycopy(nums, 0, raw, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(raw, 0, nums, 0, nums.length);
        return nums;
    }

    /**
     * fisher-yates算法
     * 主要思路为每次随机挑选一个值，放在数组末尾。
     * 然后在n-1个元素的数组中再随机挑选一个值，放在数组末尾，以此类推
     *
     * @return 打散数据
     */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; ++i) {
            int j = i + new Random().nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}