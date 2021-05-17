package com.feyfree.leetcode.p0140;


import java.util.*;

/**
 * 140. 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 * @author leilei
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return wordBreak(s, dict, mem);
    }


    private List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> mem) {
        List<String> data = mem.get(s);
        if (data != null) {
            return data;
        }
        List<String> ans = new ArrayList<>();
        if (dict.contains(s)) {
            ans.add(s);
        }
        for (int i = 1; i < s.length(); ++i) {
            String right = s.substring(i);
            if (!dict.contains(right)) {
                continue;
            }
            String left = s.substring(0, i);
            List<String> leftResult = append(wordBreak(left, dict, mem), right);
            ans.addAll(leftResult);
        }
        mem.put(s, ans);
        return ans;
    }

    private List<String> append(List<String> prefixes, String word) {
        List<String> results = new ArrayList<>();
        for (String prefix : prefixes) {
            results.add(prefix + " " + word);
        }
        return results;
    }
}