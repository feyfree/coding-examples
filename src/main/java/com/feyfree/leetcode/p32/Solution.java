package com.feyfree.leetcode.p32;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <https://leetcode-cn.com/problems/longest-valid-parentheses/>
 *
 * @author leilei
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> q = new Stack<>();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                q.push(i);
            } else {
                if (q.isEmpty()) {
                    start = i + 1;
                } else {
                    q.pop();
                    ans = Math.max(ans, q.isEmpty() ? i - start + 1 : i - q.peek());
                }
            }
        }
        return ans;
    }
}
