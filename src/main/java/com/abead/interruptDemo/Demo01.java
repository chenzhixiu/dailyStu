package com.abead.interruptDemo;

/**
 * 测试sleep 响应中断请求    */
public class Demo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        System.out.println("222" + Thread.currentThread().isInterrupted());
                        e.printStackTrace();
                    }
                    while (true){}
            }
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("111" + t1.isInterrupted());
    }
}
