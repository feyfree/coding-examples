package com.feyfree.leetcode.p8;


/**
 * 字符串转换整数(atoi)
 * string-to-integer-atoi
 *
 * @author Leilei
 */
public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        int result = 0;
        int sign = 1;
        // 跳过空字符
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        // 获取符号位
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '+') ? 1 : -1;
            i++;
        }
        // 判断其他情况
        while (i < str.length()) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // 判断是否溢出得条件, 代码到这一步的逻辑是 digit 为有效数字
            // 判断前置的result 的 value
            boolean flag = Integer.MAX_VALUE / 10 < result ||
                    (Integer.MAX_VALUE / 10 == result
                            && Integer.MAX_VALUE % 10 < digit);
            if (flag) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}
