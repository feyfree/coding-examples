package com.feyfree.leetcode.p0139;

import java.util.*;

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * <p>
 * tips: https://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
 *
 * @author leilei
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> mem = new HashMap<>();
        return wordBreak(s, mem, dict);
    }

    private boolean wordBreak(String s,
                              Map<String, Boolean> mem,
                              Set<String> dict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); ++i) {
            if (dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}
