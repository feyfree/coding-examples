package com.feyfree.leetcode.p0397;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 *
 * @author leilei
 */
class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!cache.containsKey(n)) {
            if ((n & 1) == 0) {
                cache.put(n, 1 + integerReplacement(n / 2));
            } else {
                cache.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return cache.get(n);
    }
}

