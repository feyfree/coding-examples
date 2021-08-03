package com.feyfree.leetcode.p0202;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author leilei
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next(n);
        }
        return n == 1;
    }


    private int next(int n) {
        int next = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            next += d * d;
        }
        return next;
    }
}
