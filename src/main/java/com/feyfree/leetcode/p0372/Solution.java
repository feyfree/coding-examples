package com.feyfree.leetcode.p0372;

/**
 * 372. 超级次方
 *
 * @author leilei
 */
class Solution {
    public int superPow(int a, int[] b) {
        if (a == 1) {
            return 1;
        }
        if (a > 1337) {
            a = a % 1337;
        }
        int key = 0;
        for (int j : b) {
            key = (key * 10 + j) % 1140;
        }
        int res = a;
        for (int i = 0; i < key - 1; i++) {
            res = res * a % 1337;
        }
        return res;
    }
}
