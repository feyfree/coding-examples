package com.feyfree.leetcode.p0392;

/**
 * 392. 判断子序列
 *
 * @author leilei
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int si = 0;
        for (int i = 0; i < t.length(); i++) {
            if (si < s.length() && t.charAt(i) == s.charAt(si)) {
                si++;
            }
        }
        return si == s.length();
    }
}
