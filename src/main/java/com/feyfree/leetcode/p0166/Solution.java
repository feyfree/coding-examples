package com.feyfree.leetcode.p0166;

import java.util.ArrayList;
import java.util.List;

/**
 * 166. 分数到小数
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 *
 * @author leilei
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean minus = (numerator > 0 && denominator < 0)
                || (numerator < 0 && denominator > 0);
        int absNumerator = Math.abs(numerator);
        int absDenominator = Math.abs(denominator);
        int[] divMod = divMod(absNumerator, absDenominator);
        int quotient = divMod[0];
        int remainder = divMod[1];

        List<String> result = new ArrayList<>();
        if (minus) {
            result.add("-");
        }
        result.add(String.valueOf(quotient));
        result.add(".");
        List<Integer> remainders = new ArrayList<>();
        while (!remainders.contains(remainder)) {
            remainders.add(remainder);
            divMod = divMod(remainder * 10, absDenominator);
            remainder = divMod[1];
            quotient = divMod[0];
            result.add(String.valueOf(quotient));
        }
        int idx = remainders.indexOf(remainder);
        result.add(idx + 3, "(");
        result.add(")");
        String temp = String.join("", result).replace("(0)", "");
        if (temp.charAt(temp.length() - 1) == '.') {
            return temp.substring(0, temp.length() - 1);
        }
        return temp;
    }

    private int[] divMod(int a, int b) {
        return new int[]{a % b, a / b};
    }
}