package com.feyfree.leetcode.p0258;

/**
 * https://leetcode-cn.com/problems/add-digits/
 * 258. 各位相加
 *
 * @author leilei
 */
public class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            num = func(num);
        }
        return num;
    }

    private int func(int num) {
        int sum = 0;
        while (num >= 10) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum + num;
    }
}
