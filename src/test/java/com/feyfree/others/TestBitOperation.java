package com.feyfree.others;

import org.junit.Test;

public class TestBitOperation {
    @Test
    public void and() {
        // binary : 11
        int a = 3;
        // binary: 10
        int b = 2;
        System.out.println(a & b);
    }

    @Test
    public void or() {
        // binary : 11
        int a = 3;
        // binary: 10
        int b = 2;
        System.out.println(a | b);
    }

    @Test
    public void rightMove() {
        System.out.println(1 << 2);
    }
}
