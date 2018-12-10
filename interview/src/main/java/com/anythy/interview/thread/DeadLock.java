package com.anythy.interview.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author klq
 */
public class DeadLock {
    private static AtomicInteger o1 = new AtomicInteger(1);
    private static AtomicInteger o2 = new AtomicInteger(2);



    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5));
        Lock1 lock1 = new Lock1();
        Lock2 lock2 = new Lock2();

        executorService.execute(lock1);
        executorService.execute(lock2);
    }


    static class Lock1 implements Runnable {

        @Override
        public void run() {
            synchronized(o1){
                sleep();
                System.out.println("Lock1 locked o1");
                synchronized (o2){
                    sleep();
                    System.out.println("Lock1 locked o2");
                }
            }
        }
    }

    static class Lock2 implements Runnable {

        @Override
        public void run() {
            synchronized (o2){
                sleep();
                System.out.println("Lock2 locked o2");
                synchronized (o1){
                    sleep();
                    System.out.println("Lock2 locked o1");
                }
            }
        }
    }

    static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
