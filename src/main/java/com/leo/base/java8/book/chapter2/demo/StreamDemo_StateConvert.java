package com.leo.base.java8.book.chapter2.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by estolia on 2018/1/6.
 */
public class StreamDemo_StateConvert {
    public static void main(String[] args) {
        // 这里之所以称为有状态是指要区分是否重复，在变量元素时必须记住前面遍历过的元素
        Stream<String> unique = Arrays.asList("a", "b", "c", "a", "e", "c").stream().distinct();
        System.out.println(unique.collect(Collectors.toList()));
    }
}
