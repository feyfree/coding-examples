package com.feyfree.leetcode.p0151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        int start = 0;
        List<String> store = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                start = i + 1;
            } else {
                store.add(s.substring(start, i + 1));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = store.size() - 1; i >= 0; i--) {
            result.append(store.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
    }
}