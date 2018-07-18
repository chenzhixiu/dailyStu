package com.abead.jdkDynProxyTest;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 15:13
 */
public class RealObject implements Proxy {
    @Override
    public void test() {
        System.out.println("test");
    }
}
