package com.leo.base.javas.jvm;

/**
 * Created by estolia on 2017/4/27.
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderTree.class.getClassLoader();
        while (cl != null) {
            System.out.println(cl);
            cl = cl.getParent();
        }
    }
}
