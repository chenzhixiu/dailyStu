package com.abead.interruptDemo;

/**
 * 测试处于锁等待的线程 不能响应中断
 * */
public class Demo04 {
   static class AA{
        public synchronized void f(){
            while (true){}
        }
    }
    public static void main(String[] args) {
        AA aa = new AA();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                aa.f();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                aa.f();
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
