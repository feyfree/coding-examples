package com.feyfree.others;

/**
 * 线程安全
 *
 * @author leilei
 */
public class ThreadSafeSample {
    public int sharedState;

    public void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.println("Observed data race, former is:" + former + "& latter is: " + latter);
            }
        }
    }

    public void safeAction() {
        synchronized (this) {
            while (sharedState < 100000) {
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter - 1) {
                    System.out.println("Observed data race, former is:" + former + "& latter is: " + latter);
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();
        o.notify();
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                sample.safeAction();
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                sample.safeAction();
            }
        };

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
