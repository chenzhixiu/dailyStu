package com.abead.interruptDemo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new Runnable() {
            @Override
            public void run() {
                 while (true){
                     System.out.println("1");
                 }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("2");
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("3");
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("4");
            }
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Runnable>  list = es.shutdownNow();
        System.out.println();
    }
}
