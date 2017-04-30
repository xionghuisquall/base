package com.leo.base.javas.jvm;

import com.leo.base.javas.jvm.helper.Dummy;

/**
 * Created by estolia on 2017/4/29.
 */
public class LoadAndDefineClass {
    public static void main(String[] args) {
        System.out.println(LoadAndDefineClass.class.getClassLoader());
        System.out.println(Dummy.class.getClassLoader());
        System.out.println(java.util.ArrayList.class.getClassLoader());
    }
}
