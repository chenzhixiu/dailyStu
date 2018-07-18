package com.abead.jdkDynProxyTest.aa;

public class RealObject implements ProxyInterface {
        @Override
        public void test() {
            System.out.println("test");
        }
}
