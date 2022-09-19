package com.feyfree.leetcode.p0434;

/**
 * 434. 字符串中的单词数
 * 这个无法通过测试用例！！！
 *
 * @author leilei
 */
public class Solution {
    public int countSegments(String s) {
        int result = 0;
        int last = -1;
        int index = 0;
        while (index < s.length()) {
            char current = s.charAt(index);
            if (Character.isLetter(current)) {
                if (last == -1) {
                    result++;
                }
                last = 0;
            } else {
                last = -1;
            }
            index++;
        }
        return result;
    }
}
