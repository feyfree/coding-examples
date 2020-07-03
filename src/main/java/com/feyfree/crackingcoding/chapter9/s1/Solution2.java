package com.feyfree.crackingcoding.chapter9.s1;

/**
 * 判定是否是字符重排列
 * <p>
 * <p>
 * 统计字符串各字符数量
 *
 * 熟记ASCII 码表的相对顺序 'a' -> 97
 *
 *
 *
 * @author leilei
 */
public class Solution2 {
    public boolean permutationMatch(String s1, String s2) {
        // 根据ASCII 码的长度分配定长数组
        int[] charArray = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            charArray[s1.charAt(i)]++;
        }
        for (int j = 0; j < s2.length(); j++) {
            charArray[s2.charAt(j)]--;
            if (charArray[s2.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.permutationMatch("abcd", "bacda"));
    }
}
