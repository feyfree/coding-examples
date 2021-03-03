package com.feyfree.leetcode.p0013;

import java.util.HashMap;
import java.util.Map;


public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> valMap = new HashMap<>();
        valMap.put('I', 1);
        valMap.put('V', 5);
        valMap.put('X', 10);
        valMap.put('L', 50);
        valMap.put('C', 100);
        valMap.put('D', 500);
        valMap.put('M', 1000);
        int initial = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer a = valMap.get(s.charAt(i));
            Integer b = valMap.get(s.charAt(i + 1));
            if (a < b) {
                initial -= a;
            } else {
                initial += a;
            }
        }
        initial += valMap.get(s.charAt(s.length() - 1));
        return initial;
    }
}
