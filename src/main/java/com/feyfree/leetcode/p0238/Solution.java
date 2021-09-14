package com.feyfree.leetcode.p0238;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 238. 除自身以外数组的乘积
 * <p>
 * space O(n) 解法
 *
 * @author leilei
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] result = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = l[i] * r[i];
        }
        return result;
    }
}
