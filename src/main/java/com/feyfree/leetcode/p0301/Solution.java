package com.feyfree.leetcode.p0301;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * 301. 删除无效的括号
 * <p>
 * 1.这是一道搜索的问题
 *
 * @author leilei
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                l++;
            }
            if (ch == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        List<String> result = new ArrayList<>();
        dfs(s, 0, l, r, result);
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++count;
            }
            if (ch == ')') {
                --count;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private void dfs(String s, int start, int l, int r, List<String> result) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            // We only remove the first parentheses if there are consecutive ones to avoid duplications.
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                StringBuilder curr = new StringBuilder(s);
                curr.delete(i, i + 1);
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(curr.toString(), i, l, r - 1, result);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(curr.toString(), i, l - 1, r, result);
                }
            }
        }
    }
}