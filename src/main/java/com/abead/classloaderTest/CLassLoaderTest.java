package com.abead.classloaderTest;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/5/11 16:33
 */
public class CLassLoaderTest {
    public static void test1(){
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileNmae = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream =  getClass().getResourceAsStream(fileNmae);
                if (inputStream == null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            };
        };

        try {
            Object o =  classLoader.loadClass("com.abead.classloaderTest.CLassLoaderTest").newInstance();
            System.out.println(o.getClass());
            System.out.println(o instanceof com.abead.classloaderTest.CLassLoaderTest);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
    //Object
    public static void main(String[] args) {
    }
}
