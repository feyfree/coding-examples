package com.feyfree.leetcode.p0367;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @author leilei
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int target = mid * mid;
            if (target == num) {
                return true;
            } else if (target > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(1));
    }
}
