package com.feyfree.leetcode.p91;

/**
 * dp 滚动数组解法
 *
 * @author leilei
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int w1 = 1;
        int w2 = 1;
        for (int i = 1; i < n; i++) {
            int w = 0;
            if (!isValid(s.charAt(i)) && !isValid(s.charAt(i - 1), s.charAt(i))) {
                return 0;
            }
            if (isValid(s.charAt(i))) {
                w = w1;
            }
            if (isValid(s.charAt(i - 1), s.charAt(i))) {
                w += w2;
            }
            w2 = w1;
            w1 = w;
        }
        return w1;
    }

    private boolean isValid(char a) {
        return a != '0';
    }

    private boolean isValid(char a, char b) {
        int num = (a - '0') * 10 + (b - '0');
        return num >= 10 && num <= 26;
    }
}
