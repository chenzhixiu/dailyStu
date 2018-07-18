package com.abead.threadpoollDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService =  (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i =0;i < 10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j < 10;j++){
                        System.out.println(Thread.currentThread().getName()+" "+j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
