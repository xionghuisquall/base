package com.leo.base.javas.jvm.load.case1;

/**
 * Created by estolia on 2017/11/15.
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
        new HelloB();
    }
}
