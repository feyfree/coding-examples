package com.feyfree.jvm.clazz.initialization;

public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLoopClass!");
            while (true) {
            }
        }
    }

    public static void main(String[] args) {
        Runnable scripts = () -> {
            System.out.println(Thread.currentThread() + "start!");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + "run over!");
        };
        Thread thread1 = new Thread(scripts);
        Thread thread2 = new Thread(scripts);
        thread1.start();
        thread2.start();
    }
}
