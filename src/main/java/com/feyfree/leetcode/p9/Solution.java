package com.feyfree.leetcode.p9;

/**
 * 是否是回文数
 * palindrome-number
 * <p>
 * <p>
 * 转字符串解法, 直接用StringBuilder reverse api 也可以
 *
 * @author leilei
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            String s = String.valueOf(x);
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
