package com.dubber.simplexml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created on 2018/5/14.
 *
 * @author dubber
 *
 *
 * @Root 定义为xml root节点。
 */
@Root
public class BookList {

    @ElementList(inline=true)
    private ArrayList<Book> list;

    public BookList() {
        list = new ArrayList<Book>();
    }
    public ArrayList<Book> getList() {
        return list;
    }

    public void add(Book b){
        list.add(b);
    }
    @Override
    public String toString() {
        return "BookList [list=" + list + "]";
    }
}
