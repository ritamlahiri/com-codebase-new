package com.corejava.threads;

public class RunnableThread  implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            System.out.println(" Thread "+i+" invoked "+Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }}
