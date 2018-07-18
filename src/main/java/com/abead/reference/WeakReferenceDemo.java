package com.abead.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用测试
 */
public class WeakReferenceDemo {
    private static  B bb = new B();
    static class MyWeakReference extends WeakReference{

        public MyWeakReference(Object referent) {
            super(referent);
        }

        public MyWeakReference(Object referent, ReferenceQueue q) {
            super(referent, q);
        }
    }

    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        while (true){
            //WeakReferenceDemo.test(referenceQueue);
            MyWeakReference myWeakReference = new MyWeakReference(bb,referenceQueue);
            System.gc();
            B b = null;
            if ((b = (B)myWeakReference.get()) !=  null){
                    b.getBytes();
            }
        }
    }
    static class B{
        private byte[] bytes = new byte[1024 * 1024 * 500];

        public void getBytes() {
            System.out.println("分配500M");
        }
    }
    static class A{

        A(ReferenceQueue referenceQueue){
            MyWeakReference myWeakReference = new MyWeakReference(new B(),referenceQueue);
        }
        public void f(){
            System.out.println("A");
        }
    }
    public static void test(ReferenceQueue referenceQueue){
        A a  =new A(referenceQueue);
        a.f();
    }
}
