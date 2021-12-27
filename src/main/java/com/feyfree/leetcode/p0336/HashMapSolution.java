package com.feyfree.leetcode.p0336;

import java.util.*;

/**
 * HashMap 解法
 *
 * @author leilei
 */
public class HashMapSolution {
    private final List<String> reverse = new ArrayList<>();
    private final Map<String, Integer> indices = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word : words) {
            reverse.add(new StringBuilder(word).reverse().toString());
        }
        for (int i = 0; i < n; i++) {
            indices.put(reverse.get(i), i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftIndex = findWord(word, 0, j - 1);
                    if (leftIndex != -1 && leftIndex != i) {
                        result.add(Arrays.asList(i, leftIndex));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightIndex = findWord(word, j, m - 1);
                    if (rightIndex != -1 && rightIndex != i) {
                        result.add(Arrays.asList(rightIndex, i));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    private int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}
