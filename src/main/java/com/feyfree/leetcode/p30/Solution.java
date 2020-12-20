package com.feyfree.leetcode.p30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 30 solution
 *
 * @author leilei
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        // 单个字符串长度
        int l = words[0].length();
        // 字符串数组的长度
        int n = words.length;
        if (l * n > s.length()) {
            return result;
        }
        // 构建hash map
        Map<String, Integer> expected = new HashMap<>();
        for (String word : words) {
            expected.put(word, expected.getOrDefault(word, 0) + 1);
        }
        //
        for (int i = 0; i <= s.length() - n * l; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;
            for (int j = 0; j < n; j++) {
                String w = s.substring(i + j * l, i + j * l + l);
                Integer it = expected.get(w);
                if (it == null) {
                    break;
                }
                Integer wc = seen.getOrDefault(w, 0);
                seen.put(w, wc + 1);
                if (wc + 1 > it) {
                    break;
                }
                count++;
            }
            if (count == n) {
                result.add(i);
            }
        }
        return result;
    }
}
