package com.feyfree.leetcode.p17;


import java.util.ArrayList;
import java.util.List;

/**
 * DFS 解法
 * 电话号码的字母组合
 * <p>
 * letter-combinations-of-a-phone-number
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author leilei
 */
class Solution {
    public List<String> letterCombinations(String digits) {
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
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, d, 0, cur, ans);
        return ans;
    }

    /**
     * @param digits 输入的数字
     * @param d      数字对应的字符
     * @param l      当前的index
     * @param cur    当前保留的字符数组
     * @param ans    输出
     */
    private void dfs(String digits, String[] d,
                     int l, char[] cur, List<String> ans) {
        if (l == digits.length()) {
            if (l > 0) {
                ans.add(new String(cur));
            }
            return;
        }

        String s = d[Character.getNumericValue(digits.charAt(l))];

        for (int i = 0; i < s.length(); ++i) {
            cur[l] = s.charAt(i);
            dfs(digits, d, l + 1, cur, ans);
        }
    }
}