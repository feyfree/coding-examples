package com.feyfree.leetcode.p0393;

/**
 * 393. UTF-8 编码验证
 * https://leetcode-cn.com/problems/utf-8-validation/
 *
 * @author leilei
 */
class Solution {
    public boolean validUtf8(int[] data) {
        int left = 0;
        for (int d : data) {
            if (left == 0) {
                if ((d >> 3) == 0b11110) {
                    left = 3;
                } else if (d >> 4 == 0b1110) {
                    left = 2;
                } else if (d >> 5 == 0b110) {
                    left = 1;
                } else if (d >> 7 == 0b0) {
                    left = 0;
                } else {
                    return false;
                }
            } else {
                if (d >> 6 != 0b10) {
                    return false;
                } else {
                    left--;
                }
            }
        }
        return left == 0;
    }
}
