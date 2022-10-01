package com.learning.sde.concurrency.basic;

import java.util.concurrent.*;

public class BasicConcurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BasicConcurrencyTask task = new BasicConcurrencyTask();
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        service.execute(task);
//        service.execute(task);
//        service.execute(task);
//        service.execute(task);
//        service.execute(task);
//        service.execute(task);
//        service.shutdown();

        System.out.println("Current time: " + System.currentTimeMillis());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
//        service.schedule(task, 10, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(task, 10, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(task, 10, 5, TimeUnit.SECONDS);
        scheduledFuture.get();
//        service.shutdown();
    }
}
