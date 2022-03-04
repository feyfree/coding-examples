package com.feyfree.leetcode.p0500;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/keyboard-row/
 *
 * @author leilei
 */
public class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        int[] marked = charArray();
        for (String current : words) {
            boolean flag = true;
            for (int j = 1; j < current.length(); j++) {
                if (marked[Character.toLowerCase(current.charAt(j)) - 'a'] != marked[Character.toLowerCase(current.charAt(j - 1)) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(current);
            }
        }
        return result.toArray(new String[0]);
    }

    private int[] charArray() {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        int[] result = new int[26];
        for (int i = 0; i < line1.length(); i++) {
            result[line1.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < line2.length(); i++) {
            result[line2.charAt(i) - 'a'] = 2;
        }
        for (int i = 0; i < line3.length(); i++) {
            result[line3.charAt(i) - 'a'] = 3;
        }
        return result;
    }
}
