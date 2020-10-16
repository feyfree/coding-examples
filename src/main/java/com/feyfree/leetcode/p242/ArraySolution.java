package com.feyfree.leetcode.p242;

import java.util.Arrays;

/**
 * 数组解法
 * <p>
 * 数组索引实际上是默认的key
 * <p>
 * <p>
 * 如果是默认的 是 26 个小写的字符的
 *
 * @author leilei
 */
public class ArraySolution {

    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            int[] sa = new int[26];
            int[] ta = new int[26];
            for (char m : s.toCharArray()) {
                sa[m - 'a'] += 1;
            }
            for (char n : t.toCharArray()) {
                ta[n - 'a'] += 1;
            }
            return Arrays.equals(sa, ta);
        }
        return false;
    }
}
