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
        List<String> result = new ArrayList<>();
        // 左括号数量
        int lc = 0;
        // 右括号数量
        int rc = 0;
        return new ArrayList<>();

    }

    private void dfs(String s, StringBuilder current, int lc, int rc, int index) {
        // 右括号大于左括号数量, 肯定是需要放弃的
        // 如果当前的
        if (index > s.length()) {
            return;
        }
        char c = s.charAt(index);
        if (c != '(' && c != ')') {
            current.append(c);
        }
    }


}