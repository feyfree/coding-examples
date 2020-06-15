package com.feyfree.basic.others;

/**
 * 递归实现全排列
 *
 * @author leilei
 */
public class Permutation {
    public static void permutation(String string) {
        permutation(string, "");
    }

    public static void permutation(String string, String prefix) {
        if (string.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < string.length(); i++) {
                String rem = string.substring(0, i) + string.substring(i + 1);
                permutation(rem, prefix + string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        permutation("abcd");
    }
}
