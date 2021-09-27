package com.feyfree.leetcode.p0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 241. 为运算表达式设计优先级
 *
 * @author leilei
 */
public class Solution {

    private final Map<String, List<Integer>> mem = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return ways(expression);
    }

    private List<Integer> ways(String input) {
        if (mem.containsKey(input)) {
            return mem.get(input);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftWays = ways(left);
                List<Integer> rightWays = ways(right);
                for (Integer a : leftWays) {
                    for (Integer b : rightWays) {
                        ans.add(doOp(a, b, op));
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(input));
        }
        mem.put(input, ans);
        return mem.get(input);
    }

    private int doOp(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
