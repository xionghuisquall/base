package com.leo.base.java8.book.chapter2.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by estolia on 2018/1/6.
 */
public class StreamDemo_Collect {
    public static void main(String[] args) {
        // stream.toArray() 方法只能返回Object数组
        Object[] array = Arrays.asList("a", "b", "c", "a", "e", "c").stream().map(s -> s + "1").toArray();
        System.out.println(Arrays.toString(array));

        // 若要返回特定类型数组需要提供数组构造器
        String[] array2 = Arrays.asList("a", "b", "c", "a", "e", "c").stream().map(s -> s + "1").toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        // 如果要收集到集合类中，例如HashSet等，需要保证线程安全，例如
        Set<String> set1 = Arrays.asList("a", "b", "c", "a", "e", "c").stream().map(s -> s + "1")
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println(set1);

        // 不过可以直接利用Collectors提供的方便工厂方法
        Set<String> set2 = Arrays.asList("a", "b", "c", "a", "e", "c").stream().map(s -> s + "1")
                .collect(Collectors.toSet());
        System.out.println(set2);

        // 若希望控制类型，则
        TreeSet<String> set3 = Arrays.asList("a", "b", "c", "a", "e", "c").stream().map(s -> s + "1")
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set3);

        // 求最大、平均等。其中提供的String::length方法是将元素String转换为int值得方法
        IntSummaryStatistics summaryStatistics = Arrays.asList("a", "b", "c", "a", "e", "c").stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getSum());

        // 仅仅是循环打印一下。如果下面的换成了并行流，还要确保forEach中的函数是可以并发线程安全执行的！！
        // 否则则使用forEachOrdered来强制顺序，但会损失效率
        Arrays.asList("a", "b", "c", "a", "e", "c").stream().forEach(System.out::println);
    }
}
