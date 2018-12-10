package com.anythy.interview.program;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 模拟电梯
 * @author leach
 */
@Slf4j
public class Elevator {
    private volatile int highest = 19;
    private volatile int lowest = 1;
    private volatile int currentFloor = 1;
    private volatile boolean isRun = true;
    private volatile Set<Integer> waitingUpFloors = new HashSet<>();
    private volatile Set<Integer> waitingDownFloors = new HashSet<>();

    /**
     * 点上
     * @param floor
     */
    public void clickUp(int floor){
        if(floor != highest){
            waitingUpFloors.add(floor);
        }
    }

    /**
     * 点下
     * @param floor
     */
    public void clickDown(int floor){
        if(floor != lowest){
            waitingDownFloors.add(floor);
        }
    }

    /**
     * 模拟点击
     */
    public void simulateClick(){
        System.out.println("你的楼层:");
        Scanner scanner = new Scanner(System.in);
        int floor = scanner.nextInt();
        if(floor == lowest){
            clickUp(floor);
            return;
        }else if(floor == highest){
            clickDown(floor);
            return;
        }else if(floor > highest || floor < lowest){
            simulateClick();
            return;
        }
        System.out.println(String.format("%s层乘客,上(1)/下(2)", floor));
        int upOrDown = scanner.nextInt();
        if(upOrDown == 1){
            clickUp(floor);
        }else if(upOrDown == 2){
            clickDown(floor);
        }else{
            System.out.println("重新按");
            simulateClick();
        }
    }

    public void start() throws InterruptedException {
        while (true){
            if(!isRun){
                log.info("当前楼层为{}楼", currentFloor);

            }
            Thread.sleep(1000);
        }
    }

    public void up(){
        Integer[] upfloors = new Integer[waitingUpFloors.size()];
        upfloors = waitingUpFloors.toArray(upfloors);
        Arrays.sort(upfloors);
    }


    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.simulateClick();
    }
}
