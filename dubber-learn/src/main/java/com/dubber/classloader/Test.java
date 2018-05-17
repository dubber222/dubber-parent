package com.dubber.classloader;

/**
 * Created on 2018/5/14.
 *
 * @author dubber
 */
public class Test {
    public String say(String name) {
        System.out.println("say hello!" + name);
        return "反射方法调用成功";
    }
}
