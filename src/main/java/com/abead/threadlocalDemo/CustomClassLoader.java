package com.abead.threadlocalDemo;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/6/14 9:11
 */
public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL... urls) {
        super(urls, null);
    }

    @Override
    protected void finalize() {
        System.out.println("*** CustomClassLoader finalized!");
    }
}
