package com.feyfree.leetcode.p0394;

/**
 * 394. 字符串解码
 *
 * @author leilei
 */
public class Solution {
    public String decodeString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int n = s.length();
        int c = 0;
        // 先统计数字
        while (i < n && Character.isDigit(s.charAt(i))) {
            c = c * 10 + (s.charAt(i) - '0');
            i++;
        }
        // 统计数字后面跟着的方括号的内容 确定前后索引
        int j = i + 1;
        if (i < n && s.charAt(i) == '[') {
            int open = 1;
            while (j < n && open > 0) {
                if (s.charAt(j) == '[') {
                    ++open;
                }
                if (s.charAt(j) == ']') {
                    --open;
                }
                j++;
            }
        } else {
            while (j < n && Character.isAlphabetic(s.charAt(j))) {
                j++;
            }
        }
        if (i == 0) {
            return s.substring(0, j) + decodeString(s.substring(j));
        }
        // 如果c 大于0
        String ss = decodeString(s.substring(i + 1, j - 1));
        while (c > 0) {
            ans.append(ss);
            c--;
        }
        // 封装后面的
        ans.append(decodeString(s.substring(j)));
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}

