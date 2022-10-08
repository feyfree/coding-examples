package com.feyfree.leetcode.p0443;

/**
 * https://leetcode.cn/problems/string-compression/
 *
 * @author leilei
 */
class Solution {
    public int compress(char[] chars) {
        char before = ' ';
        int count = 0;
        int result = 0;
        int modified = -1;
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            if (now == before) {
                count++;
            } else {
                if (count > 0) {
                    result += getLength(count);
                    chars[modified + 1] = before;
                    if (count > 1) {
                        String s = String.valueOf(count);
                        for (int j = 0; j < s.length(); j++) {
                            chars[++modified] = s.charAt(j);
                        }
                    }
                }
                count = 1;
            }
            before = now;
        }
        if (count > 0) {
            result += getLength(count);
            if (count > 1) {
                String s = String.valueOf(count);
                for (int j = 0; j < s.length(); j++) {
                    chars[++modified] = s.charAt(j);
                }
            }
        }
        return result;
    }

    private int getLength(int a) {
        if (a == 1) {
            return 1;
        }
        return a / 10 + 1 + 1;
    }
}