package com.feyfree.leetcode.p22;


import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>
 * generate-parentheses
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * 有效的括号组合表示 能成对
 *
 * @author leilei
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateSingleString(result, "", 0, 0, n);
        return result;
    }

    private void generateSingleString(List<String> result, String s, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(s);
        }
        // 如果左括号还没到n, 表示还可以加左括号
        if (left < n) {
            generateSingleString(result, s + '(', left + 1, right, n);
        }
        // 如果右括号小于左括号， 加上右括号
        if (right < left) {
            generateSingleString(result, s + ')', left, right + 1, n);
        }
    }
}
