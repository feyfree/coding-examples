package com.feyfree.leetcode.p0412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leilei
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0;
            boolean mod5 = i % 5 == 0;
            if (mod3 && mod5) {
                result.add("FizzBuzz");
            } else if (mod3) {
                result.add("Fizz");
            } else if (mod5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}