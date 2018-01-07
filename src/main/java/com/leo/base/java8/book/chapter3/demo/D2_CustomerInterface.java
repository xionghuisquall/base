package com.leo.base.java8.book.chapter3.demo;

import javafx.scene.paint.Color;

/**
 * Created by estolia on 2018/1/7.
 */
public class D2_CustomerInterface {
    // 该标记@FunctionalInterface似乎并非必须的，没有它，也可以用lamda表达式
    @FunctionalInterface
    private interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }

    public static void main(String[] args) {

    }


}
