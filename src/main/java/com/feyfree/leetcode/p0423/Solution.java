package com.feyfree.leetcode.p0423;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * https://leetcode.cn/problems/reconstruct-original-digits-from-english/
 * ['e','g','f','i','h','o','n','s','r','u','t','w','v','x','z']
 *
 * @author leilei
 */
class Solution {

    char[] chars = new char[]{'e', 'g', 'f', 'i', 'h', 'o', 'n', 's', 'r', 'u', 't', 'w', 'v', 'x', 'z'};
    String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    /**
     * 匹配
     */
    Map<String, Integer> values = new HashMap<>();

    Map<Character, List<String>> cMap = new HashMap<>();


    private void init() {
        for (int i = 0; i < numbers.length; i++) {
            values.put(numbers[i], i);
            for (int j = 0; j < numbers[i].length(); j++) {
                char c = numbers[i].charAt(j);
                if (cMap.containsKey(c)) {
                    cMap.get(c).add(numbers[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(numbers[i]);
                    cMap.put(c, list);
                }
            }
        }
    }


    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        return null;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'e', 'g', 'f', 'i', 'h', 'o', 'n', 's', 'r', 'u', 't', 'w', 'v', 'x', 'z'};
        String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> data = new ArrayList<>();
        for (char item : a) {
            int count = 0;
            for (String number : numbers) {
                if (number.contains(Character.toString(item))) {
                    count++;
                }
            }
            data.add(item + ":" + count);
        }
        data.sort(Comparator.comparing(o -> o.split(":")[1]));
        System.out.println(JSONObject.toJSONString(data));
    }
}