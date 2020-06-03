package com.feyfree.basic.operation;

/**
 * 位运算
 *
 * @author leilei
 */
public class BitOperation {


    static class MyInt {
        int intValue;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public MyInt(int intValue) {
            this.intValue = intValue;
        }
    }

    private static void inPlaceAndSwap(MyInt x, MyInt y) {
        y.setIntValue(x.getIntValue() ^ y.getIntValue());
        x.setIntValue(x.getIntValue() ^ y.getIntValue());
        y.setIntValue(x.getIntValue() ^ y.getIntValue());
    }

    public static void main(String[] args) {
        MyInt a = new MyInt(11);
        MyInt b = new MyInt(11);
        inPlaceAndSwap(a, b);
        System.out.println(a.getIntValue());
        System.out.println(b.getIntValue());
    }
}
