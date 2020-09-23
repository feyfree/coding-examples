package com.feyfree.basic.regex;

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
    }
}