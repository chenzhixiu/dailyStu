package com.abead.interruptDemo;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *阻塞队里里面 take 响应中断
 */
public class Demo {
    static class A{
        private BlockingQueue blockingQueue = new LinkedBlockingQueue();
        public Object f() throws InterruptedException {
                return blockingQueue.take();
        }
    }
    public static void main(String[] args) {
          Thread t1 = new Thread(new Runnable() {
              @Override
              public void run() {
                  try {
                      new A().f();
                  } catch (InterruptedException e) {
                      System.out.println(new Date() +" 我被中断了");
                      e.printStackTrace();
                  }
              }
          });
          t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       t1.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3"+t1.isInterrupted());
        System.out.println(new Date() +" main end");
    }
}
