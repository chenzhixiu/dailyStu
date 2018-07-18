package com.abead.lockSupportDemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Unsafe unsafe = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Unsafe finalUnsafe = unsafe;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park("123");
                try {
                    finalUnsafe.putObject(Thread.currentThread(), finalUnsafe.objectFieldOffset
                            (Thread.class.getDeclaredField("parkBlocker")), null);
                } catch (NoSuchFieldException e) {
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
        System.out.println(LockSupport.getBlocker(t1));
        // LockSupport.unpark(t1);
        t1.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LockSupport.getBlocker(t1));
    }
}
