package com.feyfree.basic.pool;

/**
 * @author leilei
 */
public class Worker implements Runnable {

    private final Thread thread;

    private Runnable task;


    public Worker(Runnable task) {
        this.thread = new Thread();
        this.task = task;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        thread.start();
    }

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Hello");
        Worker worker = new Worker(task);
        worker.run();
    }
}
