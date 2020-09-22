package com.feyfree.basic.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则
 *
 * @author leilei
 */
public class TestRegexBoundary {

    @Test
    public void testBeginning() {
        String text = "Line 1\nLine2\nLine3";
        Pattern pattern = Pattern.compile("^");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }

    @Test
    public void testBeginningUrl() {
        String text = "http://jenkov.com";
        Pattern pattern = Pattern.compile("^http://");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }

    @Test
    public void testEndOfLine() {
        String text = "http://jenkov.com";
        Pattern pattern = Pattern.compile(".com$");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }

    /**
     * The \b boundary matcher matches a word boundary,
     * meaning a location in an input string
     * where a word either starts or ends.
     */
    @Test
    public void testWordBoundary() {
        String text = "Mary had a little lamb";
        Pattern pattern = Pattern.compile("\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }

    @Test
    public void testWordSpecialCharacterBoundary() {
        String text = "Mary had a little lamb";
        Pattern pattern = Pattern.compile("\\bl");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }

    @Test
    public void testNoWordBoundary() {
        String text = "Mary had a little lamb";
        Pattern pattern = Pattern.compile("\\B");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
        }
    }
}
