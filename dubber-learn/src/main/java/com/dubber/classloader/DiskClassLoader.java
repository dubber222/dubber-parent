package com.dubber.classloader;

import java.io.*;

/**
 * Created on 2018/5/14.
 *
 * @author dubber
 *         <p>
 *         自定义 classloader 加载 E:\lib 中的class文件
 */
public class DiskClassLoader extends ClassLoader {

    /**
     * 自定义步骤
     * <p>
     * (1)编写一个类继承自ClassLoader抽象类。
     * (2)复写它的findClass()方法。
     * (3)在findClass()方法中调用defineClass()。
     * <p>
     * defineClass()
     * 这个方法在编写自定义classloader的时候非常重要，它能将class二进制内容转换成Class对象，如果不符合要求的会抛出各种异常。
     */
    private String dLibPath;

    public DiskClassLoader(String path) {
        this.dLibPath = path;
    }


    @Override
    public Class<?> findClass(final String name)
            throws ClassNotFoundException {
        final Class<?> result;
        try {
            String fileName = getFileName(name);
            File file = new File(dLibPath, fileName);
            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len = 0;
            while ((len = fis.read()) != -1) {
                baos.write(len);
            }
            byte[] data = baos.toByteArray();
            baos.flush();
            baos.close();
            fis.close();

            return defineClass(name,data,0,data.length);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }


    //获取要加载 的class文件名
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        } else {
            return name.substring(index + 1) + ".class";
        }
    }


}
