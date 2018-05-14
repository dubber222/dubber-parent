package com.dubber.learn;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.util.Collection;

/**
 * Created on 2018/5/14.
 *
 * @author dubber
 */
public class Main {

    public static void main(String[] args) {
        //path();
        classLoad();

    }


    private static void classLoad(){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    private static void path() {
        //得到项目的 classes 路径
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("classes 路径" + path);

        Collection<File> dirs = FileUtils.listFilesAndDirs(new File("D:\\workspace_learn\\dubber-parent\\dubber-simplexml\\src\\main\\java"), FileFilterUtils.directoryFileFilter(), FileFilterUtils.directoryFileFilter());
        System.out.println("通过common-io包，查找D:\\workspace_learn\\dubber-parent\\dubber-simplexml\\src\\main\\java路径下的所有文件和目录：");
        for (File dir : dirs) {
            String baseName = dir.getName();
            System.out.println(baseName);
        }
        System.out.println("common-io 包test结束***************************************************");
    }
}
