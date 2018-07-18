package com.abead.util;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class Demo {
   public static interface A{public void f();}
    public static void main(String[] args) {
     A a =  (A) Proxy.newProxyInstance(A.class.getClassLoader(), new Class[]{A.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return null;
            }
        });
        a.f();
    }
}
