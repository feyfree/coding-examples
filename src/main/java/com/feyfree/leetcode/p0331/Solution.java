package com.feyfree.leetcode.p0331;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * @author leilei
 */
public class Solution {
    private int pos = 0;

    public boolean isValidSerialization(String preorder) {
        return isValid(preorder) && pos == preorder.length();
    }

    private boolean isValid(String s) {
        if (pos >= s.length()) {
            return false;
        }
        if (Character.isDigit(s.charAt(pos))) {
            while (Character.isDigit(s.charAt(pos))) {
                pos++;
            }
            pos++;
            boolean left = isValid(s);
            pos++;
            boolean right = isValid(s);
            return left && right;
        }
        return s.charAt(pos++) == '#';
    }
}
