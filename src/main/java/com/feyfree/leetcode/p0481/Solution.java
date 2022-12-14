package com.feyfree.leetcode.p0481;

/**
 * https://leetcode.cn/problems/magical-string/
 * 122往后推
 *
 * @author leilei
 */
class Solution {
    public int magicalString(int n) {
        char[] s = new char[n + 2];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; i++) {
            // 1 ^ 3 = 2, 2 ^ 3 = 1
            c ^= 3;
            s[j++] = c;
            if (s[i] == 2) {
                s[j++] = c;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 2 - s[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        char a = 1;
        System.out.println(a);
    }
}
