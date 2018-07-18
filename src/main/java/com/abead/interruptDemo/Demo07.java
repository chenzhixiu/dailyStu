package com.abead.interruptDemo;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 中断之后调用阻塞方法
 */
public class Demo07 {
    static class A{
        private BlockingQueue blockingQueue = new LinkedBlockingQueue();
        public Object f() throws InterruptedException {
            Thread.currentThread().interrupt();
            return blockingQueue.take();
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Demo07.A().f();
                } catch (InterruptedException e) {
                    System.out.println(new Date() +" 我被中断了");
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // t1.interrupt();
    }
}
