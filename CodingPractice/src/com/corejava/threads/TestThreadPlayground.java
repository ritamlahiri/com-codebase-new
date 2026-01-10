package com.corejava.threads;

import com.corejava.threads.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPlayground {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService =Executors.newFixedThreadPool(3);
        CallableThread callableThread =new CallableThread();
        Future<String> future1= executorService.submit(callableThread);
        future1.get();

        RunnableThread runnableThread = new RunnableThread();
        executorService.submit(runnableThread);
        executorService.shutdown();
    }

    public void runnableDemo(){
        System.out.println("Thread name : "+Thread.currentThread().getName());
        // Create thread using extending Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Thread creation with Runnable interface -> using Lambda expression
        Runnable runnable=()->{
            System.out.println(" New Runnable  Thread - "+Thread.currentThread().getName());
        };

        Thread thread1= new Thread(runnable);
        thread1.start();
    }
}
