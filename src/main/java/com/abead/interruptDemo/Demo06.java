package com.abead.interruptDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * 读取过程中的阻塞 不响应中断 有中文结果是乱码的  不影响测试
 */
public class Demo06 {
    static class AA{
        public void f(){
            FileInputStream in = null;
            try {
                in = new FileInputStream(new File("D:\\com.json"));
                byte b = 0;
                while ((b = (byte) in.read()) != -1){
                    System.out.print((char)b);
                }
                System.out.println("read"+  new Date());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Demo06.AA aa = new Demo06.AA();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                aa.f();
            }
        });
        t1.start();
        t1.interrupt();
        System.out.println("------------------------------------"+t1.isInterrupted());
        System.out.println("-------------------------------------main"+  new Date());
    }
}
