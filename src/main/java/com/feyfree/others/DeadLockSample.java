package com.feyfree.others;

public class DeadLockSample extends Thread {
    private final String first;

    private final String second;

    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";

        DeadLockSample thread1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample thread2 = new DeadLockSample("Thread1", lockB, lockA);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
