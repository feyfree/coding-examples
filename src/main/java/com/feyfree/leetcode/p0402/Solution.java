package com.feyfree.leetcode.p0402;

/**
 * 402. 移掉 K 位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 * <p>
 * dfs 会超时
 *
 * @author leilei
 */
public class Solution {

    private String result = "*";

    private char[] chars;

    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0";
        }
        // 实际上是DFS   n 选 k 的问题
        boolean[] used = new boolean[n];
        chars = num.toCharArray();
        dfs(used, 0, 0, k, n);
        if ("".equals(result)) {
            return "0";
        }
        return result;
    }


    private void dfs(boolean[] used, int d, int s, int k, int n) {
        if (d == k) {
            result = min(result, getNumber(used));
            return;
        }
        for (int i = s; i < n; i++) {
            used[i] = true;
            dfs(used, d + 1, i + 1, k, n);
            used[i] = false;
        }

    }


    private String min(String a, String b) {
        if ("*".equals(a)) {
            return b;
        }
        if ("*".equals(b)) {
            return a;
        }
        int ai = 0;
        int bi = 0;
        while (ai < a.length()) {
            if (a.charAt(ai) != '0') {
                break;
            }
            ai++;
        }
        while (bi < b.length()) {
            if (b.charAt(bi) != '0') {
                break;
            }
            bi++;
        }
        if (ai == a.length() || bi == b.length()) {
            return "0";
        }
        if (a.length() - ai > (b.length() - bi)) {
            return b.substring(bi);
        } else if (a.length() - ai < (b.length() - bi)) {
            return a.substring(ai);
        } else {
            for (int i = 0; i < a.length() - ai; i++) {
                if (a.charAt(ai + i) > b.charAt(bi + i)) {
                    return b;
                } else if (a.charAt(ai + i) < b.charAt(bi + i)) {
                    return a;
                }
            }
            return a;
        }
    }

    private String getNumber(boolean[] used) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                number.append(chars[i]);
            }
        }
        return number.toString();
    }


}

