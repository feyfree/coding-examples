package com.feyfree.basic.regex;

import org.junit.Test;

import java.util.regex.Pattern;

public class TestRegexQualifier {

    /**
     * zero or multiple o after Hell
     */
    @Test
    public void sample() {
        String regex = "Hello*";
        System.out.println(Pattern.matches(regex, "Hell"));
        System.out.println(Pattern.matches(regex, "Hello"));
        System.out.println(Pattern.matches(regex, "Helloo"));
        System.out.println(Pattern.matches(regex, "Hellooo"));
    }

    /**
     * at least one
     */
    @Test
    public void atLeastOne() {
        String regex = "Hello+";
        System.out.println(Pattern.matches(regex, "Hell"));
        System.out.println(Pattern.matches(regex, "Hello"));
        System.out.println(Pattern.matches(regex, "Helloo"));
        System.out.println(Pattern.matches(regex, "Hellooo"));
    }

    @Test
    public void specificNum() {
        String regex = "Hello{2}";
        System.out.println(Pattern.matches(regex, "Hell"));
        System.out.println(Pattern.matches(regex, "Hello"));
        System.out.println(Pattern.matches(regex, "Helloo"));
        System.out.println(Pattern.matches(regex, "Hellooo"));
    }

    @Test
    public void specificNumRange() {
        String regex = "Hello{1,2}";
        System.out.println(Pattern.matches(regex, "Hell"));
        System.out.println(Pattern.matches(regex, "Hello"));
        System.out.println(Pattern.matches(regex, "Helloo"));
        System.out.println(Pattern.matches(regex, "Hellooo"));
    }


}
