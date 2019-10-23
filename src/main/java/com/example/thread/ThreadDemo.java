package com.example.thread;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/10/17 15:33
 * Modify Log
 **/
public class ThreadDemo extends Thread {

    public void run(){
        System.out.println("线程");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo();
        threadDemo1.start();
    }
}
