package com.feyfree.leetcode.p0383;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * @author leilei
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int ci = ransomNote.charAt(i) - 'a';
            if (--chars[ci] < 0) {
                return false;
            }
        }
        return true;
    }
}
