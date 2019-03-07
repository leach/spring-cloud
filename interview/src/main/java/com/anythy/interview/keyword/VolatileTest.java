package com.anythy.interview.keyword;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 测试volatile修饰符是否为原子操作
 */
public class VolatileTest {

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>(100);

        Runnable run = new Runnable() {
            static final long max = 999999999;
            static final long min = 0;
//            volatile long num = max;
            long num = 999999999;
//            AtomicLong num = new AtomicLong(min);

            @Override
            public void run() {
//                synchronized (this) {
                    for (int i = 0; i < 9999; i++) {
                        if( !"111011100110101100100111111111".equals(Long.toBinaryString(num))){
                            System.err.println("非原子操作:" + num);
                        }
//                        num = min;
                        num = 999999999;

//                    synchronized (this) {
//                        if( num.getAndSet(min) != min && num.getAndSet(max) != max){
//                            System.err.println("非原子操作:" + num.get());
//                        }
//                    }
//                        num.getAndSet(min);
//                        num.getAndSet(max);
                    }
                }
//            }
        };

        for (int i = 0; i < 9999; i++) {
            Thread th = new Thread(run);
            list.add(th);
        }
        for (Thread th: list){
            th.start();
        }
    }
}
