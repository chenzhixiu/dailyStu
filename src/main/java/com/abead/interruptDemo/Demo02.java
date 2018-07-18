package com.abead.interruptDemo;

/**
 * 测试join方法 响应中断
 */
public class Demo02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){}
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("222" + Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("111" + t1.isInterrupted());
    }
}
