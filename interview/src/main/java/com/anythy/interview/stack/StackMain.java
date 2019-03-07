package com.anythy.interview.stack;

import java.util.*;

public class StackMain {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public synchronized void append(int v){
        stack1.push(v);
    }

    public synchronized int head(){
        if(stack2.size() <= 0){
            while (stack1.size() > 0){
                int data = stack1.pop();
                stack2.push(data);
            }
        }
        if(stack2.size() == 0){
            System.out.println("Queue is empty!");
            return 0;
        }
        int head = stack2.pop();
        return head;
    }

    public static void main(String[] args) {
        /*StackMain stackMain = new StackMain();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    stackMain.append(i);
                    System.out.println("--------------");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(stackMain.head());
                }
            }
        }.start();*/

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(11);
        stack.push(111);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(2);
        queue.add(22);
        queue.add(222);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        String s1 = "H";
        String s2 = "L";
        String s3 = "HL";
        String s4 = "H" + "L";
        String s5 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s5);
        s1 = "kk";
        System.out.println(s5);
    }
}
