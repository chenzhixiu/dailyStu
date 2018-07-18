package com.abead.cglibTest;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 14:31
 */
public class Trace implements MethodInterceptor {

    int ident = 1;
    static Trace callback = new Trace();

    /** Creates a new instance of Trace */
    private Trace() {
    }

    public static Object newInstance(Class clazz ){
        try{
            Enhancer e = new Enhancer();
            e.setSuperclass(clazz);
            e.setCallback(callback);
            return e.create();
        }catch( Throwable e ){
            e.printStackTrace();
            throw new Error(e.getMessage());
        }

    }
    static class DemoMe implements MethodInterceptor{

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println();
            return null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");
        System.setProperty("net.sf.cglib.core.DebuggingClassWriter.traceEnabled","true");
        SimpleClass simpleClass = (SimpleClass)newInstance(SimpleClass.class);
        List list = new ArrayList();
        list.add("132");
        list.add("dg");
        simpleClass.g();
        simpleClass.sort(list);
        System.out.println();
       /* System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");
        System.setProperty("net.sf.cglib.core.DebuggingClassWriter.traceEnabled","true");
        Vector list = (Vector)newInstance(Vector.class);
        Object value = "TEST";
        list.add(value);
        list.lastElement();
        list.contains(value);
        try{
            list.set(2, "ArrayIndexOutOfBounds" );
        }catch( ArrayIndexOutOfBoundsException ignore ){

        }
        list.add(value + "1");
        list.add(value + "2");
        list.toString();
        list.equals(list);
        list.set( 0, null );
        list.toString();
        list.add(list);
        list.get(1);
        list.toArray();
        list.remove(list);
        list.remove("");
        list.containsAll(list);
        list.lastIndexOf(value);*/
    }


    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        printIdent(ident);
        System.out.println( method );
        for( int i = 0; i < args.length; i++ ){
            printIdent(ident);
            System.out.print( "arg" + (i + 1) + ": ");
            if( obj == args[i])
                System.out.println("this");
            else
                System.out.println(args[i]);
        }
        ident++;

        Object retValFromSuper = null;
        try {
            retValFromSuper = proxy.invokeSuper(obj, args);
            ident--;
        } catch (Throwable t) {
            ident--;
            printIdent(ident);
            System.out.println("throw " + t );
            System.out.println();
            throw t.fillInStackTrace();
        }

        printIdent(ident);
        System.out.print("return " );
        if( obj == retValFromSuper)
            System.out.println("this");
        else System.out.println(retValFromSuper);

        if(ident == 1)
            System.out.println();

        return retValFromSuper;
    }

    void printIdent( int ident ){


        while( --ident > 0 ){
            System.out.print(".......");
        }
        System.out.print("  ");
    }

}
