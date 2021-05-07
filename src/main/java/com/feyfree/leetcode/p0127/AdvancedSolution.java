package com.feyfree.leetcode.p0127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 双向BFS
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;

            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            Set<String> q = new HashSet<>();
            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) {
                            return steps + 1;
                        }
                        if (!dict.contains(t)) {
                            continue;
                        }
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }
            q1 = q;
        }
        return 0;
    }
}
