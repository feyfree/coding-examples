package com.feyfree.leetcode.p0424;

/**
 * https://leetcode.cn/problems/longest-repeating-character-replacement/
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 *
 * @author leilei
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        // 标记字符数组
        int[] container = new int[26];
        //
        for (char one : chars) {
            int index = one - 'A';
            container[index] = 1;
        }
        int finalResult = 0;
        for (int index = 0; index < container.length; index++) {
            if (container[index] == 0) {
                continue;
            }
            char target = (char) ('A' + index);
            // 标记数组存在
            int start = 0, end = 0;
            int count = 0;
            int tempResult = 0;
            while (end < chars.length) {
                if (chars[end] != target) {
                    count++;
                }
                while (count > k) {
                    if (chars[start] != target) {
                        count--;
                    }
                    start++;
                }
                tempResult = Math.max(tempResult, end - start + 1);
                end++;
            }
            finalResult = Math.max(tempResult, finalResult);
        }
        return finalResult;
    }
}