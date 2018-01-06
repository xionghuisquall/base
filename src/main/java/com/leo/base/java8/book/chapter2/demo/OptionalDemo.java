package com.leo.base.java8.book.chapter2.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by estolia on 2018/1/6.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // add的返回值在map操作后会返回给Optional<Boolean> added
        int test = new Random().nextInt() % 2;
        List<String> result = new ArrayList<>();
        Optional<String> value = Optional.ofNullable(test == 0 ? "hello" : null);
        Optional<Boolean> added = value.map(result::add);
        System.out.println(test);
        System.out.println(result);
        added.ifPresent(System.out::println);
        System.out.println("==finish");

        //
        Optional<Double> value2 = Optional.of(-4.0).flatMap(OptionalDemo::inverse).flatMap(OptionalDemo::squreroot);
        value2.ifPresent(System.out::println);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squreroot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

}
