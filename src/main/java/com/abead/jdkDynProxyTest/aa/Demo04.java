package com.abead.jdkDynProxyTest.aa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class Demo04{
    public static void main(String[] args) {
       RealObject realObject = new RealObject();
      ProxyInterface proxy = (ProxyInterface)Proxy.newProxyInstance(realObject.getClass().getClassLoader(),new Class[]{ProxyInterface.class},new InvocationHandler(){
                 @Override
                  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                         System.out.println("1111");
                          method.invoke(realObject);
                          System.out.println("222");
                          return null;
                }
       });
    }
}
