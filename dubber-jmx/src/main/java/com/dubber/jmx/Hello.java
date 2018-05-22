package com.dubber.jmx;

/**
 * Created on 2018/5/21.
 *
 * @author dubber
 */
public class Hello implements HelloMBean{

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String printHello() {
        return "Hello "+ name;
    }

    @Override
    public String printHello(String whoName) {
        return "Hello  " + whoName;
    }
}
