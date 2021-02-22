package com.feyfree.leetcode.p87;

/**
 * p87 扰乱字符串
 * <p>
 * hint by:
 * https://zxi.mytechroad.com/blog/searching/leetcode-87-scramble-string/
 *
 * @author leilei
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        int l = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        if (!sameFrequency(s1, s2)) {
            return false;
        }
        for (int i = 1; i < l; i++) {
            boolean valid = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                    || isScramble(s1.substring(0, i), s2.substring(l - i, l)) && isScramble(s1.substring(i), s2.substring(0, l - i));
            if (valid) {
                return true;
            }
        }
        return false;
    }

    private boolean sameFrequency(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}