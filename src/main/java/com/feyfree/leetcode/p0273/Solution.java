package com.feyfree.leetcode.p0273;

/**
 * https://leetcode-cn.com/problems/integer-to-english-words/
 * 273. 整数转换英文表示
 *
 * @author leilei
 */
public class Solution {

    private final String[] under20 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] under100 = new String[]{"Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] units = new String[]{"Hundred", "Thousand", "Million", "Billion"};

    private final int[] unitVal = new int[]{100, 1000, 1000 * 1000, 1000 * 1000 * 1000};


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return convert(num).substring(1);
    }

    private String convert(int n) {
        if (n == 0) {
            return "";
        }
        if (n < 20) {
            return " " + under20[n - 1];
        }
        if (n < 100) {
            return " " + under100[n / 10 - 2] + convert(n % 10);
        }
        for (int i = 3; i >= 0; --i) {
            if (n >= unitVal[i]) {
                return convert(n / unitVal[i]) + " " + units[i] + convert(n % unitVal[i]);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String data = solution.convert(100);
        System.out.println(data);
    }
}
