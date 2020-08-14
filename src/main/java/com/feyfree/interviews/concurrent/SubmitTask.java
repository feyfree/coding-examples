package com.feyfree.interviews.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmitTask {
    // we will be running only 2 threads in our ThreadPool
    private static final int DEFAULT_THREAD_COUNT = 2;
    private final ThreadPoolExecutor executorService =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(DEFAULT_THREAD_COUNT);

    /*
    if we only submit task to executor service
    then our thread pool will not closed
    even after completion of processing callable threads.
    */
    public <T> Future<T> submitTask(Callable<T> callable) {
        return executorService.submit(callable);
    }

    /*
    This is a blocking call, invokeAll will execute all the task in the
    executor service and store all
    */
    public void invokeAll(List<Callable<Long>> callableList) {
        try {
            // execute all callable and store the results to future
            // it is a blocking call
            List<Future<Long>> futures = executorService.invokeAll(callableList);
            for (Future<Long> future : futures) {
                Long processedData = future.get();
                System.out.println("Thread Id " + processedData);
            }
            executorService.shutdownNow();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /*
    We need to forcefully shutdown our executor service pool.
     */
    public void shutdownNow() {
        executorService.shutdownNow();
    }

    private static long randomMilliSecond() {
        return (long) (Math.random() * 10) * 1000;
    }

    public static void main(String... args) throws ExecutionException, InterruptedException {
        List<Callable<Long>> callableTasks = new ArrayList<>();
        Callable<Long> callable = () -> {
            Thread.sleep(randomMilliSecond());
            // some computed value
            return Thread.currentThread().getId();
        };
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        /*
        Executing each task in executorService.submit method.
         */
        SubmitTask submit = new SubmitTask();
        for (Callable<Long> task : callableTasks) {
            Future<Long> future = submit.submitTask(task);
            // future.get() is blocking call
            Long computedResult = future.get();
            System.out.println(computedResult);
        }
        submit.shutdownNow();
        /*
        Executing all task using executorService.invokeAll method.
        Invoke all is a blocking call.
         */
        submit.invokeAll(callableTasks);
        /*
        Handling exception of you executing task.
         */
        SubmitTask handleException = new SubmitTask();
        Callable<Long> someTask = callableTasks.get(0);
        Future<Long> calledSomeTask = handleException.submitTask(someTask);
        try {
            calledSomeTask.get();
        } catch (Exception e) {
            System.out.println("Caught the exception, handle carefully!!!");
        } finally {
            handleException.shutdownNow();
        }
        /*
        How to cancel further task in Executor Service ?
         */
        SubmitTask cancelTask = new SubmitTask();
        int counter = 0;
        for (Callable<Long> task : callableTasks) {
            Future<Long> future = cancelTask.submitTask(task);
            if (counter == 0) {
                // future.get() is blocking call
                Long computedResult = future.get();
                System.out.println(computedResult);
            } else {
                // cancel all our task from processing
                future.cancel(true);
            }
            ++counter;
        }
        cancelTask.shutdownNow();
    }
}