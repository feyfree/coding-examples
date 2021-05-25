package com.feyfree.leetcode.p0150;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * @author leilei
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> items = new Stack<>();
        for (String item : tokens) {
            if (!isOperator(item)) {
                items.push(Integer.valueOf(item));
            } else {
                // items 弹出
                Integer b = items.pop();
                Integer a = items.pop();
                items.push(calculateByOperator(a, b, item));
            }
        }
        return items.pop();
    }


    private boolean isOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator) || "/".equals(operator) || "*".equals(operator);
    }

    /**
     * 通过运算符计算
     *
     * @param a        数字a
     * @param b        数字b
     * @param operator 运算符
     */
    private int calculateByOperator(int a, int b, String operator) {
        if ("+".equals(operator)) {
            return a + b;
        }
        if ("-".equals(operator)) {
            return a - b;
        }
        if ("/".equals(operator)) {
            return a / b;
        }
        if ("*".equals(operator)) {
            return a * b;
        }
        return 0;
    }
}
