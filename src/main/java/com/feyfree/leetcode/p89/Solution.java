package com.feyfree.leetcode.p89;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷码编码
 * 参考leetcode-cn上面的解法
 * <p>
 * 关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
 * 如 n = 3:
 * G(0) = 000,
 * G(1) = 1 ^ 0 = 001 ^ 000 = 001
 * G(2) = 2 ^ 1 = 010 ^ 001 = 011
 * G(3) = 3 ^ 1 = 011 ^ 001 = 010
 * G(4) = 4 ^ 2 = 100 ^ 010 = 110
 * G(5) = 5 ^ 2 = 101 ^ 010 = 111
 * G(6) = 6 ^ 3 = 110 ^ 011 = 101
 * G(7) = 7 ^ 3 = 111 ^ 011 = 100
 *
 * @author leilei
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            ret.add(i ^ i >> 1);
        }
        return ret;
    }
}
