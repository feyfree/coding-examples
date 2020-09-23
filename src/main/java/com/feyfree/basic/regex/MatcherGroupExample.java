package com.feyfree.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matcher group
 * <p>
 * The group with number 0 is always the whole regular expression.
 * To get access to a group marked by parentheses
 * you should start with group numbers 1.
 *
 * @author leilei
 */


public class MatcherGroupExample {

    public static void main(String[] args) {
        String text =
                "John writes about this, and John Doe writes about that," +
                        " and John Wayne writes about everything.";
        String patternString1 = "(John) (.+?) ";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("found: " + matcher.group(1) +
                    " " + matcher.group(2));
        }
    }
}

