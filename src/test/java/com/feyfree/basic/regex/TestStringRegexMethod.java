package com.feyfree.basic.regex;

import org.junit.Test;

/**
 * String 里面的 正则
 *
 * @author leilei
 */
public class TestStringRegexMethod {

    @Test
    public void testStringMatch() {
        String text = "one two three two one";
        boolean matches = text.matches(".*two.*");
        System.out.println(matches);
    }
}
