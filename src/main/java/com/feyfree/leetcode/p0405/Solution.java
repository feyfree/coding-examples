package com.feyfree.leetcode.p0405;

class Solution {
    public String toHex(int num) {
        String s = Integer.toBinaryString(num);
        int i = s.length();
        StringBuilder builder = new StringBuilder();
        while (i > 0) {
            builder.append(Integer.toHexString(Integer.parseInt(s.substring(Math.max(i - 4, 0), i), 2)));
            i -= 4;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(26));
        Solution solution = new Solution();
        String data = solution.toHex(26);
        System.out.println(data);
    }
}
