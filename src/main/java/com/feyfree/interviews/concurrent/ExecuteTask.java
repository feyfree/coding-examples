package com.feyfree.interviews.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 *
 * @author leilei
 * @date 2020/8/14 16:33
 */
public class ExecuteTask {

    /**
     * we will be running only 2 threads in our ThreadPool
     */
    private static final int DEFAULT_THREAD_COUNT = 2;
    private final ThreadPoolExecutor executorService =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(DEFAULT_THREAD_COUNT);

    public void executeTask(Runnable runnable) {
        executorService.execute(runnable);
    }

    /**
     * For shutting down our Executor service we have used two approaches
     * wait for all threads to complete and await termination
     * <p>
     * There is an issue while using waitForAllThreadsToCompletion
     * If our thread process run and didn't terminated then..
     * our loop will run for infinite time and our program
     * will not terminate.
     * In this process we need to be assure that all of our thread
     * will complete its task.
     */
    public void waitForAllThreadsToCompletion() {
        // this will stop taking new thread in pool
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // loop until executor service is terminated
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // ignoring exception
            }
        }
        executorService.shutdownNow();
    }

    /**
     * There is an issue while using awaitTermination
     * If our thread process is still running but expected time in    awaitTermination
     * is reached then we need be force kill all of our thread.
     * In this process we need to be assure that all of our task will be completed in await time. (i.e 3000 MILLISECONDS)
     */
    public void awaitTermination() {
        try {
            // this will stop taking new thread in pool
            executorService.shutdown();
            /**
             *             awaitTermination blocks until all tasks have
             *             completed execution after a shutdown request,
             *             or the timeout occurs, or the current thread
             *             is interrupted, whichever happens first.
             */
            if (!executorService.awaitTermination(3000, TimeUnit.MILLISECONDS)) {
                // attempts to stop all actively executing tasks
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long randomMilliSecond() {
        return (long) (Math.random() * 10) * 1000;
    }

    public static void main(String... args) {
        List<Runnable> runnableTasks = new ArrayList<>();
        // let us create some task
        Runnable task = () -> {
            try {
                Thread.sleep(randomMilliSecond());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Complete processing.");
        };
        runnableTasks.add(task);
        runnableTasks.add(task);
        runnableTasks.add(task);
        runnableTasks.add(task);
        // dump all the task to Executor service, fire and forget
        ExecuteTask executor = new ExecuteTask();
        runnableTasks.forEach(executor::executeTask);
        // for shutting down executeService
        executor.waitForAllThreadsToCompletion();
        // another way to shutdown executorService
        // execute.awaitTermination();
    }
}