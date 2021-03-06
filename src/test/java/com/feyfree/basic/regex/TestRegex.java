package com.feyfree.basic.regex;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 测试用例
 *
 * @author leilei
 */
public class TestRegex {

    @Test
    public void testPatternSample() {
        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";
        String regex = ".*http://.*";
        boolean matches = Pattern.matches(regex, text);
        System.out.println("matches = " + matches);
    }

    @Test
    public void testMatchedSample() {
        String text =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String regex = "is";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }

    @Test
    public void testMatchingDigits() {
        String regex = "Hi\\d";
        boolean matches = Pattern.matches(regex, "Hi1");
        System.out.println(matches);
        boolean unmatched = Pattern.matches(regex, "Him");
        System.out.println(unmatched);
    }

    @Test
    public void testNoDigits() {
        String regex = "Hi\\D";
        boolean matches = Pattern.matches(regex, "Hi1");
        System.out.println(matches);
    }

    @Test
    public void testMatchingAnyCharacterInSet() {
        String regex = "H[ae]llo";
        System.out.println(Pattern.matches(regex, "Hello"));
    }
}
