package com.leo.base.java8.book.chapter1.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by estolia on 2018/1/4.
 */
public class E08 {
    public static void main(String[] args) {
        String[] names = {"jack", "peter", "adam"};
        List<Runnable> runnables = new ArrayList<>();
        for (String name : names) {
            runnables.add(() -> System.out.println(name));
        }

        for (Runnable r : runnables) {
            r.run();
        }
    }
}
