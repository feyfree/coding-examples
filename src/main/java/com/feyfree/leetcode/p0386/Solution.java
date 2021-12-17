package com.feyfree.leetcode.p0386;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * 386. 字典序排数
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int num = 1;
        while (result.size() < n) {
            while (num <= n) {
                result.add(num);
                num *= 10;
            }
            while (num % 10 == 9 || num > n) {
                num /= 10;
            }
            num += 1;
        }
        return result;
    }
}
