package com.feyfree.leetcode.p0389;

/**
 * 389. 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author leilei
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff += (t.charAt(i) - s.charAt(i));
        }
        return (char) (t.charAt(t.length() - 1)  + diff);
    }
}
