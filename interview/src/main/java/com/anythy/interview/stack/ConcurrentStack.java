package com.anythy.interview.stack;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack {
    AtomicReference<Node> top = new AtomicReference<Node>();
    public void push(Node node){
        Node oldTop;
        do{
            oldTop = top.get();
            node.next = oldTop;
        }
        while(!top.compareAndSet(oldTop, node));
    }
    public Node pop(int time) throws InterruptedException {
        Node newTop;
        Node oldTop;
        do{
            oldTop = top.get();
            if(oldTop == null){
                return null;
            }
            newTop = oldTop.next;
            TimeUnit.SECONDS.sleep(time);
        }
        while(!top.compareAndSet(oldTop, newTop));
        return oldTop;
    }


    public static class Node {
        public final String item;
        public Node next;
        public Node(String item){
            this.item = item;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ConcurrentStack stack = new ConcurrentStack();
        stack.push(new Node("A"));
        stack.push(new Node("B"));


        new Thread(() -> {
            try {
                stack.pop(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Node A = stack.pop(0);
                stack.pop(0);
                stack.push(new Node("D"));
                stack.push(new Node("C"));
                stack.push(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



        TimeUnit.SECONDS.sleep(10);
    }
}
