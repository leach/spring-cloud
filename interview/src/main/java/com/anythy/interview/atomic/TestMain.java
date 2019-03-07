package com.anythy.interview.atomic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestMain {

    public static void main(String[] args) {

//        ExecutorService pool = Executors.newFixedThreadPool(1, new NameThreadFactory());
        /*ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 100, 100, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new NameThreadFactory());
        pool.prestartAllCoreThreads();
        Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            pool.execute(new MyTask(counter));
        }

        pool.shutdown();*/

        List<Thread> list = new ArrayList(100);
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            MyTask t = new MyTask(counter);
            list.add(t);
        }
        for (int i = 0; i < 1000; i++) {
            list.get(i).start();
        }
    }


    public static class MyTask extends Thread {
        private Counter counter;

        public MyTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println(counter.get());
        }
    }

    public static class NameThreadFactory implements ThreadFactory {
        private static int t_id = 0;
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "A" + t_id);
            return t;
        }
    }

    public static class Counter {
        private AtomicReference<Integer> n = new AtomicReference<>(0);
//        private AtomicInteger n = new AtomicInteger(0);

        public Counter() {
        }
        public Counter(AtomicReference<Integer> n) {
            this.n = n;
        }
        public int add(){
            return n.get();
        }
        public int get(){
//            this.add();
            while(true){
                if(n.compareAndSet(n.get(), n.get() + 1)){
                    break;
                }
            }
            return n.get();
        }
    }


}
