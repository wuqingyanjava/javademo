package com.example.thread;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/10/17 15:39
 * Modify Log
 **/
public class ThreadDemoTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("线程2");
    }

    public static void main(String[] args) {
        ThreadDemoTwo threadDemoTwo = new ThreadDemoTwo();
        Thread thread = new Thread(threadDemoTwo);
        thread.start();
    }
}
