package com.dubber.jmx;

/**
 * Created on 2018/5/21.
 *
 * @author dubber
 */
public interface HelloMBean {

    public String getName();
    public void setName(String name);
    public String printHello();
    public String printHello(String whoName);
}
