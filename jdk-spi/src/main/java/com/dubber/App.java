package com.dubber;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);

        Iterator<Search> it = serviceLoader.iterator();

        Search search = null;
        while(it.hasNext()){
            search = it.next();
            System.out.println(search.search("你是谁"));
        }
    }
}
