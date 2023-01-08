package com.feyfree.leetcode.p1004;

/**
 * 1004. 最大连续1的个数 III
 *
 * @author leilei
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        // 双指针解法 维护区间
        int start = 0, end = 0;
        int result = 0;
        int count = 0;
        while (end < n) {
            // 如果右边界为 0 计数直接 +1
            if (nums[end] == 0) {
                count++;
            }
            // 当 K 次数用完了， 需要移动左边界
            while (count > k) {
                // 如果左边界为 0, 那么可以节省一次 (因为上面的操作中 0会计数一次)
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
}
