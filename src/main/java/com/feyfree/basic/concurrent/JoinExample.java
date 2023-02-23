package com.feyfree.basic.concurrent;

public class JoinExample {

    private static class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private static class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}
