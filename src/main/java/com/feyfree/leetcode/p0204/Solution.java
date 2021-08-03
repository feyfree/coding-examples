package com.feyfree.leetcode.p0204;


/**
 * 计算质数的数量
 * https://leetcode-cn.com/problems/count-primes/
 *
 * @author leilei
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }


    private boolean isPrime(int m) {
        if (m <= 1) {
            return false;
        } else if (m == 2) {
            return true;
        } else {
            for (int i = 2; i < Math.sqrt(m) + 1; i++) {
                if (m % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
