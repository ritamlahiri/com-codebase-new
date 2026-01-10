package com.corejava.threads;

import java.util.concurrent.*;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<1000000;i++){
            System.out.println(" Thread "+i+" invoked "+Thread.currentThread().getName());
            Thread.sleep(10);
    } return "HttpStatus.OK";
}
}
