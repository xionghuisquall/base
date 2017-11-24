package com.leo.base.javas.jvm.load;

/**
 * Created by estolia on 2017/8/20.
 */
public class LoadSequenceDemo extends Parent {
    public static String field = "6";

    public String field2 = "7";

    public LoadSequenceDemo() {
        System.out.println(10);
    }


    {
        System.out.println(field2);
        System.out.println("9");
    }

    static {
        System.out.println(field);
        System.out.println("8");
    }

    public static void main(String[] args) {
        new LoadSequenceDemo();
    }
}
