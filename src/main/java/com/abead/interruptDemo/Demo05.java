package com.abead.interruptDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 lockInterruptibly 锁等待的线程 可以响应中断
 */
public class Demo05 {
    static class AA{
        private ReentrantLock lock = new ReentrantLock();
        public void f(){
            try {
                lock.lockInterruptibly();
                while (true){}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
    public static void main(String[] args) {
        Demo05.AA aa = new Demo05.AA();
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
