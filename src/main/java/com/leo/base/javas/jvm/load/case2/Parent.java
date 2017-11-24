package com.leo.base.javas.jvm.load;

/**
 * Created by estolia on 2017/8/20.
 */
public class Parent {
    public static String field = "1";

    public String field2 = "2";

    public Parent() {
        System.out.println(5);
    }

    {
        System.out.println(field2);
        System.out.println("4");
    }

    static {
        System.out.println(field);
        System.out.println("3");
    }


}
