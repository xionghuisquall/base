package com.leo.base.java8.book.chapter2.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by estolia on 2018/1/6.
 */
public class StreamDemo_OperateStream {
    public static void main(String[] args) {
        // 通过施加filter操作创建新的stream。 filter参数类型是Predicate<T>函数，即从T到boolean的转换函数
        List<String> words = Arrays.asList("A", "bcc", "ca");
        Stream<String> newStream = words.stream().filter(s -> s.length() > 0 && s.startsWith("b"));
        System.out.println(newStream.collect(Collectors.toList()));

        // map 使用方法引用
        // TODO 问题是如何知道方法引用中，是p.method调用，还是 method(p) 传参?? 编译器推导??
        List<String> upper = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upper);

        // map 使用lamda表达式
        List<Character> first = words.stream().map(s -> s.charAt(0)).collect(Collectors.toList());
        System.out.println(first);

        // map vs. flatMap
        // 形如 [['A'], ['b', 'c', 'c',], ['c', 'a']]
        // TODO 这样的嵌套stream如何编写简单的代码来操作它的结果(除了改为flatMap)??
        Stream<Stream<Character>> streamStream = words.stream().map(s -> characterStream(s));
        // 形如 ['A', 'b', 'c', 'c', 'c', 'a']
        Stream<Character> characterStream = words.stream().flatMap(s -> characterStream(s));
        System.out.println(characterStream.collect(Collectors.toList()));
    }

    private static Stream<Character> characterStream(String word) {
        List<Character> characters = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }
}
