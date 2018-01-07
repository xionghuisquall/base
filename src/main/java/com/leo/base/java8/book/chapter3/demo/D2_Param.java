package com.leo.base.java8.book.chapter3.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by estolia on 2018/1/7.
 */
public class D2_Param {
    private static class Person {
        private String id;
        private String name;
        private int age;

        public Person(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static void incrementAge(List<Person> persons, UnaryOperator<Person> f) {
        for (Person p : persons) {
            f.apply(p);
        }
    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("1", "jack", 28),
                new Person("2", "Danny", 14),
                new Person("3", "Jone", 34));
        incrementAge(persons, p -> {
            p.setAge(p.getAge() + 1);
            return  p;
        });

        System.out.println(persons);
    }
}
