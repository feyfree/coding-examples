package com.feyfree.leetcode.p0345;

public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (isVowel(chars[start]) && isVowel(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
                continue;
            }
            if (!isVowel(chars[start])) {
                start++;
            }
            if (!isVowel(chars[end])) {
                end--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'E' || c == 'e'
                || c == 'I' || c == 'i' || c == 'O' || c == 'o'
                || c == 'U' || c == 'u';
    }
}
