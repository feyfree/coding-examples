package com.feyfree.basic.regex;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * pattern pattern
 *
 * @author leilei
 */
public class PatternPatternExample {

    public static void main(String[] args) {
        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);
        String pattern2 = pattern.pattern();
        System.out.println(pattern2);


        String temp = "abcdefghijklmnopqrstuvwxyz0123456789";

        char[] data = temp.toCharArray();
        System.out.println(Arrays.toString(data));
    }
}