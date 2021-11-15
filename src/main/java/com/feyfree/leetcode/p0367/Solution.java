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
            // 用乘法会存在 mid * mid;
            int t = num / mid;
            if (t == mid) {
                if (num % mid == 0) {
                    return true;
                }
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(Integer.MAX_VALUE));
    }
}
