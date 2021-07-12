package com.feyfree.basic.concurrent;

/**
 * @author leilei
 */
public class VolatileExample {

    private volatile int value = 0;


    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    ++example.value;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    ++example.value;
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    ++example.value;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println(example.value);
    }

}
