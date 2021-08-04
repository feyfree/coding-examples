package com.feyfree.leetcode.p0205;

/**
 * 205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author leilei
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
