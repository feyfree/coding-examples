package com.feyfree.leetcode.p0187;

import java.util.*;

/**
 * 187. 重复的DNA序列
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 *
 * @author leilei
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> container = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int begin = 0; begin <= s.length() - 10; begin++) {
            String current = s.substring(begin, begin + 10);
            if (container.contains(current)) {
                result.add(current);
            } else {
                container.add(current);
            }
        }
        return new ArrayList<>(result);
    }
}
