package com.feyfree.leetcode.p0398;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 398. 随机数索引
 *
 * @author leilei
 */
class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int n = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            n++;
            if (new Random().nextInt() % n == 0) {
                index = i;
            }
        }
        return index;
    }
}
