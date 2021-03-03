package com.feyfree.leetcode.p0032;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <https://leetcode-cn.com/problems/longest-valid-parentheses/>
 * <p>
 * 参考huahua c++ 解法
 * <https://zxi.mytechroad.com/blog/stack/leetcode-32-longest-valid-parentheses/>
 *
 * @author leilei
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> q = new Stack<>();
        // 起点
        int start = 0;
        // 迭代更新结果
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号所在位置入栈
                q.push(i);
            } else {
                // 如果是右括号 检查栈是否为空  如果是空的话 计算位置更新
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
