package com.abead.interruptDemo;

/**
 * 测试wait方法 响应中断
 */
public class Demo03 {
    static class AA{
        public synchronized void f(){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1213");
        }
    }
    public static void main(String[] args) {
        Demo03.AA aa = new Demo03.AA();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                aa.f();
            }
        });
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
}
