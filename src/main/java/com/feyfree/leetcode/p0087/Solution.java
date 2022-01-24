package com.feyfree.leetcode.p0087;

import java.util.HashMap;
import java.util.Map;

/**
 * p87 扰乱字符串
 * <p>
 * hint by:
 * https://zxi.mytechroad.com/blog/searching/leetcode-87-scramble-string/
 * ----------
 * 20220124测试用例更新, 需要增加一个map用于保存临时状态
 * key: s1 + s2
 * val: bool
 * <p>
 * updated
 *
 * @author leilei
 */
class Solution {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int l = s1.length();
        String key = s1 + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        if (!sameFrequency(s1, s2)) {
            map.put(key, false);
            return false;
        }
        for (int i = 1; i < l; i++) {
            boolean valid = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                    || isScramble(s1.substring(0, i), s2.substring(l - i, l)) && isScramble(s1.substring(i), s2.substring(0, l - i));
            if (valid) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    private boolean sameFrequency(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}