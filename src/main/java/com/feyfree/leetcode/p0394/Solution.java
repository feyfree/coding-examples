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
        while (i < n && Character.isDigit(s.charAt(i))) {
            c = c * 10 + (s.charAt(i) - '0');
            i++;
        }
        int j = i;
        if (i < n && s.charAt(i) == '[') {
            int open = 1;
            while (++j < n && open > 0) {
                if (s.charAt(j) == '[') {
                    ++open;
                }
                if (s.charAt(j) == ']') {
                    --open;
                }
            }
        } else {
            while (j < n && Character.isAlphabetic(s.charAt(j))) {
                j++;
            }
        }
        if (i == 0) {
            return s.substring(0, j) + decodeString(s.substring(j));
        }
        String ss = decodeString(s.substring(i + 1, j - 1));
        while (c-- > 0) {
            ans.append(ss);
        }
        ans.append(decodeString(s.substring(j)));
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.decodeString("3[a]2[bc]");
    }
}

