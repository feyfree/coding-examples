package com.feyfree.jvm.runtime;

public class SystemExitDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
            System.exit(0);
        });
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.err.println("Happy");
        }
        Thread.sleep(10000);




    }
}
