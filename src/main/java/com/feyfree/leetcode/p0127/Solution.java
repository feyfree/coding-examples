package com.feyfree.leetcode.p0127;

import java.util.*;


/**
 * 127. 单词接龙
 * 单向BFS
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * @author leilei
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int l = beginWord.length();
        int steps = 0;
        while (!q.isEmpty()) {
            ++steps;
            for (int s = q.size(); s > 0; --s) {
                String w = q.poll();
                char[] chars = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) {
                            continue;
                        }
                        chars[i] = c;
                        String t = new String(chars);
                        if (t.equals(endWord)) {
                            return steps + 1;
                        }
                        if (!dict.contains(t)) {
                            continue;
                        }
                        dict.remove(t);
                        q.offer(t);
                    }
                    chars[i] = ch;
                }
            }
        }
        return 0;
    }
}
