package com.dubber.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 2018/5/14.
 *
 * @author dubber
 */
public class ClassLoaderTest {


    /**
     * Test.class文件是由AppClassLoader加载的
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       /* ClassLoader cl = Test.class.getClassLoader();
        System.out.println("Test.class ClassLoader is:" + cl.toString());
        System.out.println("Test.class ClassLoader is:" + cl.getParent().toString());*/

       /* ClassLoader cInt = int.class.getClassLoader();
        System.out.println("int.class ClassLoader is:" + cInt.toString());*/

        //测试自定义ClassLoader
        runDiskClassLoader();


    }

    private static void runDiskClassLoader() {
        //创建自定义ClassLoader 对象
        DiskClassLoader diskClassLoader = new DiskClassLoader("E:\\lib");

        try {
            //加载class文件
            Class c = diskClassLoader.loadClass("com.dubber.classloader.Test2");

            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    System.out.println(c.getName());
                    Method method = c.getDeclaredMethod("say", String.class);
                    //通过反射调用Test类的say方法
                    Object obj2 = method.invoke(obj, "您好！");
                    System.out.println(obj2.toString());

                } catch (InstantiationException
                        | IllegalAccessException
                        | NoSuchMethodException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
