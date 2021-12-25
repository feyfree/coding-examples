package com.feyfree.leetcode.p0336;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法 - 肯定会超时的
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i], words[j])) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    result.add(cur);
                }
                if (isPalindrome(words[j], words[i])) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(j);
                    cur.add(i);
                    result.add(cur);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String a, String b) {
        String s = a + b;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
