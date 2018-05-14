package com.dubber.classloader;

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
        ClassLoader cl = Test.class.getClassLoader();
        System.out.println("Test.class ClassLoader is:" + cl.toString());
        System.out.println("Test.class ClassLoader is:" + cl.getParent().toString());

       /* ClassLoader cInt = int.class.getClassLoader();
        System.out.println("int.class ClassLoader is:" + cInt.toString());*/


    }
}
