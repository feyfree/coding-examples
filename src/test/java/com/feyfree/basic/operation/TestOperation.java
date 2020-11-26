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

    /**
     * 测试异或操作
     *
     * @author leilei
     */
    @Test
    public void testExclusiveOr() {
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ false);
    }


    @Test
    public void testPlusPlusResult() {
        int a = 8;
        a = a++;
        System.out.println(a);
    }

    @Test
    public void testDouble() {
        double a = (double) (1 << 28) + (172701471);
        long value = (long) a;
        System.out.println(value);
        System.out.println(value >> 28);
        double b = (double) ((((long) a) << 28 + 1) << 28) + 172701471;
    }

    @Test
    public void testDouble2() {
        System.out.println(1 >> 28 + 1);
    }

    public double incr(Double a) {
        System.out.println(a.longValue() >> 28 + 1);
        return (double) ((a.longValue() >> 28 + 1) << 28) + 172701471;
    }

    @Test
    public void testIncr() {
        double a = (double) (1 << 28) + 172701471;
        for (int i = 0; i < 100000; i++) {
            a = newIncr(a);
        }
    }

    private double newIncr(double a) {
        long result = (long) a >> 28;
        double b = (double) ((result + 1) << 28) + 172701471;
        long bResult = (long) b >> 28;
        System.out.println(bResult);
        return b;
    }

    private void incrLong(long bResult) {
        double c = (double) ((bResult + 1) << 28) + 172701471;
        long cResult = (long) c >> 28;
        System.out.println(cResult);
    }

    @Test
    public void testLoopIncr() {
        double a = (double) (1 << 28) + 172701471;
        System.out.println(Double.valueOf(a).longValue() >> 28);
        double v = incr(a);
        long result = Double.valueOf(v).longValue() >> 28;
        System.out.println(result);
    }
}
