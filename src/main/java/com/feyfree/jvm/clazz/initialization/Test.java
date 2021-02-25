package com.feyfree.jvm.clazz.initialization;

public class Test {
    static {
        i = 0;
        // illegal forward reference
//        System.out.println(i);
    }

    static int i = 1;

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
//        System.out.println(i);
        System.out.println(Sub.B);
    }

}
