package com.feyfree.leetcode.p0374;

import java.util.Random;

/**
 * 猜数字大小
 *
 * @author leilei
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}



