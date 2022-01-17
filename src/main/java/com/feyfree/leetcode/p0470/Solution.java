package com.feyfree.leetcode.p0470;

/**
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 *
 * @author leilei
 */
public class Solution extends SolBase {
    public int rand10() {
        int first, second;
        while ((first = rand7()) > 6) {
        }
        while ((second = rand7()) > 5) {
        }
        return (first & 1) == 1 ? second : 5 + second;
    }
}
