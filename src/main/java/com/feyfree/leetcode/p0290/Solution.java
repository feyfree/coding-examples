package com.feyfree.leetcode.p0290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 * 290. 单词规律
 *
 * @author leilei
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        // 相当于存数组索引值， 简化代码逻辑
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }
}
