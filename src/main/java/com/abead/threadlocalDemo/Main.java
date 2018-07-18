package com.abead.threadlocalDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/6/14 9:13
 */
public class Main<T,M> {
    static class Foo{
          private float a = 100.22f;
    }
    private  ThreadLocal<Foo> tl = new ThreadLocal<Foo>();
    public static void main(String...args) throws Exception {

          AtomicInteger nextHashCode =
                new AtomicInteger();
        Main main = new Main();
       Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 17;++i){
                    main.tl.set(new Foo());
                    main.tl.get();
                    main.tl.remove();
                    main.tl = null;
                    main.tl.get();
                    main.tl.set(new Foo());
                }
            }
        });t1.start();
      /*  loadFoo();
        while (true) {
            System.gc();
            Thread.sleep(1000);
        }*/
    }
}
