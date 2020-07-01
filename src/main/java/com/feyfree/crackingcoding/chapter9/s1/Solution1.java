package com.feyfree.crackingcoding.chapter9.s1;

/**
 * 判定字符是否唯一
 * <p>
 * ps: 最牛b的正则表达式解法
 * <p>
 * return !s.matches(".*(.)(.*\\1).*");
 * <p>
 * 假定字符串是 a - z (这道题意义不大， 因为字符永远是有限个的, 根据抽屉原理计算量并不是很大)
 *
 * @author leilei
 */
public class Solution1 {
    public boolean noRepeatedWords(String str) {
        // 如果字符串长度大于 26 则肯定有重复字符
        if (str.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
