package com.feyfree.leetcode.p66;

import java.util.Arrays;

/**
 * p66 加一
 *
 * @author leilei
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        // 判断什么时候需要复制数组
        // 判断什么时候需要进位
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int flag = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            current += flag;
            flag = current / 10;
            current = current % 10;
            // 如果不产生进位
            digits[i] = current;
            if (flag == 0) {
                break;
            }
        }
        if (flag == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = flag;
            System.arraycopy(digits, 0, result, 1, digits.length + 1 - 1);
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }
}
