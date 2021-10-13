package com.feyfree.leetcode.p0796;

/**
 * 796. 旋转字符串
 *
 * @author leilei
 */
public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (check(s, goal, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String a, String b, int offset) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt((i + offset) % a.length()) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
