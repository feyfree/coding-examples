package com.feyfree.basic.enclosure;

/**
 * 类似于闭包的感觉
 *
 * @author leilei
 */
public class Outer {
    private int y = 5;

    private class Inner {
        private int x = 10;

        public int add() {
            return x + y;
        }
    }

    void getAddResult() {
        Inner inner = new Inner();
        System.out.println(inner.add());
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getAddResult();
    }
}