package com.leo.base.java8.book.chapter2.demo;

import java.util.*;
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

        //
        List<Person> persons = makePersons();
        System.out.println(persons);
        Stream<String> stream = persons.stream().flatMap(p ->
            p.getHobbies().stream().map(h -> h.get("hobby")).collect(Collectors.toSet()).stream()
        );
        Set<String> hobbies = stream.collect(Collectors.toSet());
        System.out.println(hobbies);

        //
        List<String> hobbies2 = persons.stream().flatMap(p -> p.getHobbies().stream()).map(h -> h.get("hobby")).distinct().collect(Collectors.toList());
        System.out.println(hobbies2);
    }

    private static Stream<Character> characterStream(String word) {
        List<Character> characters = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }

    private static List<Person> makePersons() {
        List<Person> persons = new ArrayList<>();

        Person p1 = new Person();
        p1.setId("adam");

        List<Map<String, String>> hobbies = new ArrayList<>();
        Map<String, String> hobby = new HashMap<>();
        hobby.put("hobby", "singing");
        hobbies.add(hobby);

        hobby = new HashMap<>();
        hobby.put("hobby", "drawing");
        hobbies.add(hobby);
        p1.setHobbies(hobbies);

        persons.add(p1);

        //
        p1 = new Person();
        p1.setId("jack");

        hobbies = new ArrayList<>();
        hobby = new HashMap<>();
        hobby.put("hobby", "football");
        hobbies.add(hobby);

        hobby = new HashMap<>();
        hobby.put("hobby", "singing");
        hobbies.add(hobby);
        p1.setHobbies(hobbies);

        persons.add(p1);

        return persons;
    }

    private static class Person {
        private String id;
        private List<Map<String, String>> hobbies;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Map<String, String>> getHobbies() {
            return hobbies;
        }

        public void setHobbies(List<Map<String, String>> hobbies) {
            this.hobbies = hobbies;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", hobbies=" + hobbies +
                    '}';
        }
    }
}
