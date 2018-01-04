package com.leo.base.java8.book.chapter1.exercise;

/**
 * Created by estolia on 2018/1/4.
 */
public class E07 {
    private static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }

    public static void main(String[] args) {
        Runnable r = andThen(() -> System.out.println("run first"), () -> System.out.println("run second"));
        r.run();
    }
}
