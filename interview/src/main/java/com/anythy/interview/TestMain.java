package com.anythy.interview;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.LongStream;

public class TestMain {

    public static void main(String[] args) {

//        Long num = 1000000000000000000L;
//        System.out.print(--num);
//        Object a = new int[]{1};
//
//        String str = new String("name");
//        System.out.println(str.hashCode());
//        System.out.println(str.hashCode());
//        TestMain testMain = new TestMain();
//        System.out.println(1);

        /*Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();

        char v[] = {'a', 'v'};
        System.out.println(v);*/

        long v[] = LongStream.range(0, 1000).toArray();
        System.out.println(Arrays.toString(v));

        ForkJoinPool pool = new ForkJoinPool();
        long r = pool.invoke(new Task(v, 0, v.length - 1));
        System.out.println(r);
    }

    public static class Task extends RecursiveTask<Long>{
        private long[] numbers;
        private int from;
        private int to;

        public Task(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 当需要计算的数字小于6时，直接计算结果
            if (to - from < 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
                // 否则，把任务一分为二，递归计算
            } else {
                int middle = (from + to) / 2;
                Task taskLeft = new Task(numbers, from, middle);
                Task taskRight = new Task(numbers, middle + 1, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }
    }
}
