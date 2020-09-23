package com.feyfree.basic.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author leilei
 */
public class MatcherFindStartEndExample {

    public static void main(String[] args) {
        String text =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";
        String patternString = "is";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }
}