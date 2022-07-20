package com.feyfree.leetcode.p0459;

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * s + s 实际上是确定了 s 所有移动的可能性
 * 比如s = abc
 * s + s = abcabc
 * 这个abcabc 包含了abc 的移动的所有变种
 * <p>
 * 实际上需要证明， 小于 length - 1 的移动能使得 s 复原的话， s 一定是由重复字串构成
 *
 * @author leilei
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String data = s + s;
        return data.substring(1, data.length() - 1).contains(s);
    }
}
