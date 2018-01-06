package com.leo.base.java8.book.chapter2.demo;

import java.math.BigInteger;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 创建stream的一些方法
 * Created by estolia on 2018/1/6.
 */
public class StreamDemo_CreateStream {
    public static void main(String[] args) {
        // 传入数组的参数
        Stream s = Stream.of(args);
        // 如果可变参数的第一个非null,则不会报NPE
        s = Stream.of("1", null);
        // 下面的会报NPE
        // s = Stream.of(null);
        // TODO empty的stream有什么用??
        Stream<String> empty = Stream.empty();  // 泛型String是被编译器推导出来的
        // TODO 无线的stream有什么用??
        // 创建无线stream的两个方法 1：
        Stream<String> infiniStream1 = Stream.generate(() -> "Echo");
        // System.out.println(infiniStream1.count()); // 直接count好像是死循环
        Stream<Double> infiniStream2 = Stream.generate(Math::random);
        // 利用种子seed和函数来生成stream。执行上类似seed, f(seed), f(f(seed)), f(f(f(seed)))...
        Stream<BigInteger> bigIntegerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        // 一些其他api中也提供了stream支持。例如
        // Pattern
        Stream<String> pstream = Pattern.compile("[\\P{L}]+").splitAsStream("safwefwefwef");
        // Files
        // try (Stream<String> lines = Files.lines(path)) {
        // }
    }
}
