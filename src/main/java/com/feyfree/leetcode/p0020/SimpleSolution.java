package com.feyfree.leetcode.p0020;

import java.util.HashMap;
import java.util.Stack;

/**
 * 简化版本
 *
 * @author leilei
 */
public class SimpleSolution {
    public boolean isValid(String s) {
        Stack<Character> result = new Stack<>();
        HashMap<Character, Character> parenMap = new HashMap<>(4);
        parenMap.put(')', '(');
        parenMap.put(']', '[');
        parenMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!parenMap.containsKey(c)) {
                result.push(c);
            } else if (result.isEmpty() || !parenMap.get(c).equals(result.pop())) {
                return false;
            }
        }
        return result.isEmpty();
    }
}
