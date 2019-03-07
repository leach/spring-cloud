package com.anythy.interview.stack;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        String str = "hello";
//        ReferenceQueue<String> rq = new ReferenceQueue<String>();
        WeakReference<String> wf = new WeakReference(new String("hello"));
        System.out.println(wf.get());
        System.gc();
        System.out.println(wf.get());
    }
}
