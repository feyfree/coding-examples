package com.feyfree.leetcode.p0292;

/**
 * https://leetcode-cn.com/problems/nim-game/
 * 292. Nim 游戏
 *
 * @author leilei
 */
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 == 0;
    }
}
