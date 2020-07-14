package com.feyfree.basic.operation;

import org.junit.Test;

public class TestOperation {
    @Test
    public void testPlusPlus() {
        int n = 7;
        int m = 7;
        int a = 2 * ++m; // now a is 16, m = 8
        int b = 2 * n++; // now b is 14 , n =8
        System.out.println(m);
        System.out.println(n);
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void testForLoop() {
        int i = 0;
        for (int j = 0; j < 50; j++) {
            i = i++;
        }
        System.out.println(i);
    }

}
