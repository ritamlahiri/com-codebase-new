package com.corejava.threads;

import com.corejava.threads.MyThread;

public class TestThread {
    public static void main(String[] args) {
        System.out.println("Thread name : "+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
