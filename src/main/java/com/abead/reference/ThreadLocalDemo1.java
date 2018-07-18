package com.abead.reference;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class ThreadLocalDemo1 {
    static class B{
        ThreadLocal threadLocal = new ThreadLocal();//ThreadLocal在成员变量位置
        private byte[] bytes = new byte[1024 * 1024 * 100];
        B(){
            threadLocal.set(this);
        }

        public void getBytes() {
            System.out.println(Thread.currentThread().getName()+":  分配了500M");
        }

        public void f(){
            B b = (B)threadLocal.get();
            if (b != null){
                 b.getBytes();
            }
        }
    }
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        ExecutorService service = Executors.newFixedThreadPool(2);
        int i = 0;
        while (i < 2){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        B b =new B();
                        b.f();
                        System.gc();
                    }
                }
            });
            i++;
        }
    }
}
