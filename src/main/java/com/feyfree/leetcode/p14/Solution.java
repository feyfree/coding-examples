package com.feyfree.leetcode.p14;

/**
 * 最长的公共前缀
 * <p>
 * longest-common-prefix
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author leilei
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        // 找到长度最小的字符串
        String shortest = strs[0];
        for (String i : strs) {
            if (i.length() < shortest.length()) {
                shortest = i;
            }
        }
        // 对于shortest 判断公共前缀 【0， end】
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortest.length(); i++) {
            for (String j : strs) {
                if (j.charAt(i) != shortest.charAt(i)) {
                    return result.toString();
                }
            }
            result.append(shortest.charAt(i));
        }
        return result.toString();
    }
}