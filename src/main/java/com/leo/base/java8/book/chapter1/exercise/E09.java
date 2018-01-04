package com.leo.base.java8.book.chapter1.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by estolia on 2018/1/4.
 */
public class E09 {
    public interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            Iterator<T> it = this.iterator();
            while (it.hasNext()) {
                T t = it.next();
                if (filter.test(t)) {
                    action.accept(t);
                }
            }
        }
    }

    public static class MyArrayList<T> extends ArrayList<T> implements Collection2<T> {

    }

    public static class Student {
        String firstName;
        String lastName;
        public Double grade;
        Double feeDiscount = 0.0;
        Double baseFee = 20000.0;

        public Student(String firstName, String lastName, Double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public void printFee() {
            Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
            System.out.println("The fee after discount: " + newFee);
        }

        public Double getGrade() {
            return grade;
        }

        public void setFeeDiscount(Double feeDiscount) {
            this.feeDiscount = feeDiscount;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", grade=" + grade +
                    ", feeDiscount=" + feeDiscount +
                    ", baseFee=" + baseFee +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyArrayList<Student> stus = new MyArrayList();
        Student s1 = new Student("Jack", "London", 9.0);
        Student s2 = new Student("John", "Dorr", 1.0);
        Student s3 = new Student("Andy", "Tomson", 10.0);
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);

        System.out.println("before -------------");
        for (Student stu : stus) {
            System.out.println(stu);
        }

        stus.forEachIf(student -> student.feeDiscount = 30.0,
                //Lambda expression for Consumer inerface
                student -> student.getGrade() > 8.5);

        System.out.println("after -------------");
        for (Student stu : stus) {
            System.out.println(stu);
        }
    }
}
