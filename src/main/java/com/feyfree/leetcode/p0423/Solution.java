package com.feyfree.leetcode.p0423;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reconstruct-original-digits-from-english/
 * ['e','g','f','i','h','o','n','s','r','u','t','w','v','x','z']
 *
 * @author leilei
 */
class Solution {
    private final String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    /**
     * 因为 zero 里面有 z, eight 里面有 g
     */
    private final int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        int n = s.length();
        int[] counts = new int[26];
        // step1: mark the number of each char
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // step2: search by order : zero, eight
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            // 比如对于 zero 而言每个数字 计算最多能成多少 组， 比如 1组 zero， 所以需要排查多少个 z， 多少个 e， 多少个 r
            for (char c : ss[i].toCharArray()) {
                k = Math.min(k, counts[c - 'a']);
            }

            for (char c : ss[i].toCharArray()) {
                counts[c - 'a'] -= k;
            }
            while (k-- > 0) {
                sb.append(i);
            }
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);

    }
}
