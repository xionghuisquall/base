package com.leo.base.java8.book.chapter2.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by estolia on 2018/1/6.
 */
public class StreamDemo_Aggr {
    public static void main(String[] args) {
        // TODO 再理解下max的运作方式，因为compareToIgnoreCase方法需要p.compareToIgnoreCase(other)这样的形式
        Optional<String> largest = Arrays.asList("a", "b", "c", "a", "e", "c").stream().max(String::compareToIgnoreCase);
        if (largest.isPresent()) {
            System.out.println(largest.get());
        }

        // 并行计算的例子，下面两行等价的?
//        Optional<String> any = Arrays.asList("a", "b", "c", "a", "e", "c").stream().parallel()
        Optional<String> any = Arrays.asList("a", "b", "c", "a", "e", "c").parallelStream()
                .filter(s -> s.startsWith("a")).findAny();
        if (any.isPresent()) {
            System.out.println(any.get());
        }

        /*
           类似下面这种聚合函数，要求操作函数满足
           1、v1 op v2 op v3 op v4 ...
           2、交换律： (v1 op v2) op v3 = v1 op (v2 op v3)
           这样可以利用并行计算提高效率
           下面的操作满足上面要求：
           求和、求积、求最大、求最小、求并集、求交集、字符串追加。
           而减法操作则不是！
         */
        // 求sum
        Optional<Integer> sum = Arrays.asList(1, 2, 3, 4, 5).stream().reduce((x, y) -> x + y);
        sum.ifPresent(System.out::println);

        // 如果有一个标识值e可以作为起点值，使得 e op x = x，那么可以省去Optional类型。如下
        Integer sum2 = Arrays.asList(1, 2, 3, 4, 5).stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum2);

        // 如果转换前后的类型发生了变化，例如String, String -> int，则需要两个函数。如下是求stream中所有String的总长度
        int totalLength = Arrays.asList("a", "b", "c", "a", "e", "c").stream()
                .reduce(0, (total, s) -> total + s.length(), (total1, total2) -> total1 + total2);
        System.out.println(totalLength);
        // 或者是更简单的做法
        int totalLength2 = Arrays.asList("a", "b", "c", "a", "e", "c").stream().mapToInt(String::length).sum();
        System.out.println(totalLength2);
    }
}
