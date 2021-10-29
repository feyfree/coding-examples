package com.feyfree.leetcode.p0306;

import java.util.ArrayList;
import java.util.List;

/**
 * 306. 累加数
 * https://leetcode-cn.com/problems/additive-number/
 *
 * @author leilei
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < (n / 2 + 1); i++) {
            for (int j = 1; j < n + 1 - i; j++) {
                if (additive(num.substring(0, i), num.substring(i, i + j), num.substring(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean invalid(String s) {
        return s.length() != 1 && s.charAt(0) == '0';
    }

    private boolean additive(String s1, String s2, String right) {
        if (invalid(s1) || invalid(s2)) {
            return false;
        }
        String s3 = add(s1, s2);
        if (right.startsWith(s3)) {
            if (right.equals(s3)) {
                return true;
            }
            return additive(s2, s3, right.substring(s3.length()));
        }
        return false;
    }

    private String add(String s1, String s2) {
        List<Integer> data = new ArrayList<>();
        int i = 0, j = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int flag = 0;
        while (i < l1 && j < l2) {
            int sum = s1.charAt(l1 - 1 - i) - '0' + s2.charAt(l2 - 1 - j) - '0' + flag;
            data.add(sum % 10);
            flag = sum / 10;
            i++;
            j++;
        }
        while (i < l1) {
            int sum = s1.charAt(l1 - 1 - i) - '0' + flag;
            data.add(sum % 10);
            flag = sum / 10;
            i++;
        }
        while (j < l2) {
            int sum = s2.charAt(l2 - 1 - j) - '0' + flag;
            data.add(sum % 10);
            flag = sum / 10;
            j++;
        }
        if (flag == 1) {
            data.add(1);
        }
        StringBuilder result = new StringBuilder();
        for (Integer item : data) {
            result.append(item);
        }
        return result.reverse().toString();
    }

}

