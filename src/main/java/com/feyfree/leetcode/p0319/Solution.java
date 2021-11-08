package com.feyfree.leetcode.p0319;

/**
 * https://leetcode-cn.com/problems/bulb-switcher/
 * 319. 灯泡开关
 *
 * @author leilei
 */
public class Solution {
    public int bulbSwitch(int n) {
        // 4 = 2 * 2 (但是实际上只会按2一次) 1 * 4
        // 6 = 1 * 6, 2 * 3
        return (int) Math.sqrt(n);
    }
}
