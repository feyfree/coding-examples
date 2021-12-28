package com.feyfree.leetcode.p0331;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * <p>
 * If a node is not null, it must has two children, thus verify left subtree and right subtree recursively.
 * If a node is null, the current char must be ‘#’
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
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValidSerialization("1");
    }
}
