package com.feyfree.leetcode.p0020;


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
        Stack<Character> container = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}') {
                if (container.size() == 0) {
                    return false;
                } else {
                    Character pop = container.pop();
                    if (pop != '{') {
                        return false;
                    }
                    continue;
                }
            } else if (c == ')') {
                if (container.size() == 0) {
                    return false;
                } else {
                    Character pop = container.pop();
                    if (pop != '(') {
                        return false;
                    }
                    continue;
                }

            } else if (c == ']') {
                if (container.size() == 0) {
                    return false;
                } else {
                    Character pop = container.pop();
                    if (pop != '[') {
                        return false;
                    }
                    continue;
                }
            }
            container.push(c);
        }
        return container.size() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("[{}]"));
    }
}
