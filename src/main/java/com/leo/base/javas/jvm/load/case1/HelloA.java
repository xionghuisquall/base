package com.leo.base.javas.jvm.load.case1;

/**
 * Created by estolia on 2017/11/15.
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("static A");
    }
}
