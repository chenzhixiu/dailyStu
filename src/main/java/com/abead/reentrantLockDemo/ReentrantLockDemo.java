package com.abead.reentrantLockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static class AA implements  Runnable{
        private ReentrantLock reentrantLock = new ReentrantLock();
        private Condition condition = reentrantLock.newCondition();
        @Override
        public void run() {
            reentrantLock.lock();
            System.out.print("123");
            reentrantLock.unlock();
        }
    }

    static class A {
        private ReentrantLock reentrantLock = new ReentrantLock();
        private Condition condition = reentrantLock.newCondition();

        public void f() {
            reentrantLock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signal();
            reentrantLock.unlock();
        }
        public void g(){
            reentrantLock.lock();
            condition.signal();
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new AA()).start();
        A a = new A();
        a.f();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.f();
            }
        });
        t1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
       // LockSupport.unpark(t1);
    }
}
