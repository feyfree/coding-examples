package com.feyfree.leetcode.p12;

/**
 * 整数转罗马数字
 * <p>
 * integer-to-roman
 * <p>
 * 参考之前的python提交  tips: 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内
 *
 * @author leilei
 */
public class Solution {
    public String intToRoman(int num) {
        String[] valArray = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
                "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
                "M", "MM", "MMM"
        };
        int[] numArray = new int[4];
        int i = 3;
        while (num > 0) {
            numArray[i] = num % 10;
            num = num / 10;
            i--;
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            if (numArray[j] != 0) {
                result.append(valArray[9 * (3 - j) + numArray[j] - 1]);
            }
        }
        return result.toString();
    }
}
