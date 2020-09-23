package com.feyfree.basic.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author leilei
 */
public class CreateMatcherExample {

    public static void main(String[] args) {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";
        String patternString = "This is the";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
    }
}