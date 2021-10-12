package com.feyfree.leetcode.p0299;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 * 299. 猜数字游戏
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 *
 * @author leilei
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int a = 0;
        int b = 0;
        // 统计位数
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            }
            int number = secret.charAt(i) - '0';
            count[number]++;
        }
        for (int i = 0; i < secret.length(); i++) {
            int number = guess.charAt(i) - '0';
            if (secret.charAt(i) == guess.charAt(i)) {
                count[number]--;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int number = guess.charAt(i) - '0';
            if (count[number] > 0 && secret.charAt(i) != guess.charAt(i)) {
                b++;
                count[number]--;
            }
        }
        return a + "A" + b + "B";
    }
}
