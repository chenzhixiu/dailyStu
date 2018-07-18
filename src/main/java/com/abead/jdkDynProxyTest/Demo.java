package com.abead.jdkDynProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 15:14
 */
public class Demo {
    public static void main(String[] args) {
      /*  Object o = 1;
        System.out.println((int) o);
        Class <?> t = int.class;
        System.out.println(t.cast(o));*/
        List<String> s = new ArrayList();
        List<Integer> s1 = new ArrayList();
        s.iterator();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s.getClass() == s1.getClass());
        boolean a = true;
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealObject realObject = new RealObject();
        com.abead.jdkDynProxyTest.Proxy proxy =  (com.abead.jdkDynProxyTest.Proxy)Proxy.newProxyInstance(realObject.getClass().getClassLoader(),new Class[]{com.abead.jdkDynProxyTest.Proxy.class},new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("1111");
                method.invoke(realObject);
                System.out.println("222");
                return null;
            }
        });
        proxy.test();
    }
}
