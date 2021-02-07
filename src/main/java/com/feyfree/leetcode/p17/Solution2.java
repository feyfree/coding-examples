package com.feyfree.leetcode.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * 解法2
 * <p>
 * BFS
 *
 * @author leilei
 */
class Solution2 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] d = new String[]{" ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String t : ans) {
                String s = d[Character.getNumericValue(digit)];
                for (int i = 0; i < s.length(); ++i) {
                    tmp.add(t + s.charAt(i));
                }
            }
            ans = tmp;
        }

        return ans;
    }
}