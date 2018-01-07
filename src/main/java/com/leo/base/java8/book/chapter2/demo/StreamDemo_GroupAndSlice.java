package com.leo.base.java8.book.chapter2.demo;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by estolia on 2018/1/7.
 */
public class StreamDemo_GroupAndSlice {
    public static void main(String[] args) {
        // groupBy
        Map<String, List<Locale>> localeMap = Stream.of(Locale.getAvailableLocales()).collect(Collectors.groupingBy(Locale::getCountry));
        for (Map.Entry<String, List<Locale>> entry : localeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 利用Predicate函数进行分组（由于是Boolean类型，只有两组）
        // TODO 如何得到多组??
        Map<Boolean, List<Locale>> localeMap2 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy(l ->l.getLanguage().equals("en")));
        System.out.println(localeMap2.size());

        /* downstream examples */
        Map<String, Long> localeMap3 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        System.out.println(localeMap3);
    }
}
