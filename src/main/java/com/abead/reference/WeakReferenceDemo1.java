package com.abead.reference;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本例中回收的是A的对象
 */
public class WeakReferenceDemo1 {
    static class MyWeakReference extends WeakReference {
        Object object;
        public MyWeakReference(Object referent,Object o) {
            super(referent);
            this.object = o;
        }

        public MyWeakReference(Object referent, ReferenceQueue q,Object o) {
            super(referent, q);
            this.object = o;
        }
    }

    static class B{
        private byte[] bytes = new byte[1024 * 1024 * 500];

        public void getBytes() {
            System.out.println("分配500M");
        }
    }

    static class A{

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
                        MyWeakReference myWeakReference = new MyWeakReference(new B(),referenceQueue,new A());
                        System.gc();
                    }
                }
            });
            i++;
        }
    }
}
