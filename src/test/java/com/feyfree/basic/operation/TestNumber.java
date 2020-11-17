package com.feyfree.basic.operation;

import org.junit.Test;

public class TestNumber {

    @Test
    public void autoTransform() {
        // 必须要加括号
        int data = (1 << 28) + 100;
        System.out.println(data);

        double result = (double) (1 << 28) + 100;
        System.out.println(result);
    }

}
