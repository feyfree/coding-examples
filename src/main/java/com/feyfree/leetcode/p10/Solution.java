package com.feyfree.leetcode.p10;

/**
 * 正则表达式匹配
 * <p>
 * regular-expression-matching
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    /**
     * 模式匹配
     *
     * @param s  字符数组
     * @param p  模式数组
     * @param si 字符索引
     * @param pi 模式数组索引
     * @return 是否匹配
     */
    private boolean isMatch(char[] s, char[] p, int si, int pi) {
        if (pi == p.length) {
            return si == s.length;
        }
        if (p.length > 1 && p[1] != '*') {
            if (s.length == si) {
                return false;
            }
            if (s[si] == p[pi] || p[pi] == '.') {
                return isMatch(s, p, si + 1, pi + 1);
            } else {
                return false;
            }
        } else {
            int i = -1;
            while (i == -1 || s[si] == p[0] || p[0] == '.') {
                if (isMatch(s, p, si + i + 1, pi + 2)) {
                    return true;
                }
                if (++i == s.length) {
                    break;
                }
            }
            return false;
        }
    }
}
