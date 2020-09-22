package com.feyfree.basic.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 运算符
 *
 * @author leilei
 */
public class TestRegexLogicalOperator {

    @Test
    public void testAnd() {
        String text = "Cinderella and Sleeping Beauty sat in a tree";
        Pattern pattern = Pattern.compile("[Cc][Ii].*");
        Matcher matcher = pattern.matcher(text);
        System.out.println("matcher.matches() = " + matcher.matches());
    }

    @Test
    public void testOr() {
        String text = "Cinderella and Sleeping Beauty sat in a tree";
        Pattern pattern = Pattern.compile(".*Ariel.*|.*Sleeping Beauty.*");
        Matcher matcher = pattern.matcher(text);
        System.out.println("matcher.matches() = " + matcher.matches());
    }
}
