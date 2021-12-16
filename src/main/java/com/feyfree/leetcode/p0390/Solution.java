package com.feyfree.leetcode.p0390;

/**
 * https://leetcode-cn.com/problems/elimination-game/
 * 390. 消除游戏
 *
 * @author leilei
 */
public class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
