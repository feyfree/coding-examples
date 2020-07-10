package com.feyfree.leetcode.p20;


import java.util.Stack;

/**
 * 有效的括号
 * valid-parentheses
 *
 * @author leilei
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }
}
