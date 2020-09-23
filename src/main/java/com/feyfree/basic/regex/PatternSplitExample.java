package com.feyfree.basic.regex;

import java.util.regex.Pattern;

/**
 * pattern split
 *
 * @author leilei
 */
public class PatternSplitExample {

    public static void main(String[] args) {
        String text = "A sep Text sep With sep Many sep Separators";
        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);
        String[] split = pattern.split(text);
        System.out.println("split.length = " + split.length);
        for (String element : split) {
            System.out.println("element = " + element);
        }
    }
}