package com.feyfree.leetcode.p0165;

/**
 * 165. 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 *
 * @author leilei
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        for (int i = 0; i < array1.length && i < array2.length; i++) {
            int v1 = getValidNumber(array1[i]);
            int v2 = getValidNumber(array2[i]);
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }
        if (array1.length > array2.length) {
            for (int i = array2.length; i < array1.length; i++) {
                int v1 = getValidNumber(array1[i]);
                if (v1 > 0) {
                    return 1;
                }
            }
        }
        if (array1.length < array2.length) {
            for (int i = array1.length; i < array2.length; i++) {
                int v2 = getValidNumber(array2[i]);
                if (v2 > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private int getValidNumber(String input) {
        if (input.length() > 0) {
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (current != '0') {
                    return Integer.parseInt(input.substring(i));
                }
            }
        }
        return 0;
    }
}