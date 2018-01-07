package com.leo.base.java8.book.chapter2.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by estolia on 2018/1/7.
 */
public class StreamDemo_CollectToMap {
    public static void main(String[] args) {
        Map<String, String> map1 = Arrays.asList(new Person("1", "jack"),
                new Person("2", "Tony"),
                // 如果增加这一行，则会因为存在重复的key值而抛出IllegalStateException
//                new Person("2", "Tony"),
                new Person("3", "John"))
                .stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(map1);

        // 收集value为Person类型
        Map<String, Person> map2 = Arrays.asList(new Person("1", "jack"),
                new Person("2", "Tony"),
                new Person("3", "John"))
                .stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(map2);

        //
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, String> localMap = localeStream.collect(Collectors.toMap(lo -> lo.getDisplayName(),
                lo -> lo.getDisplayName(lo),
                (exist, newValue) -> newValue));
        System.out.println(localMap);

        // 如果下面的过程换成并行收集方式，则要用toConcurrentMap方法来保证线程安全，且效率相比合并多个Map更高
        Stream<Locale> localeStream2 = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> localMap2 = localeStream2.collect(Collectors.toMap(lo -> lo.getDisplayCountry(),
                lo -> Collections.singleton(lo.getDisplayLanguage()),
                (existSet, newSet) -> {
                    Set<String> s = new HashSet<>(existSet);
                    s.addAll(newSet);
                    return s;
                }));
        for (Map.Entry<String, Set<String>> entry : localMap2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static class Person {
        private String id;
        private String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
