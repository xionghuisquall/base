package com.leo.base.javas.thread.frombook.jcip.chapter5_jdkcomponent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        this.set.add(i);
    }

    public synchronized void remove(Integer i) {
        this.set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }

        /**
         * 这里会隐式的调用HashSet的toString方法，而该方法内部会进行迭代器的调用，
         * 从而引发ConcurrentModificationException的风险！！
         *
         * 虽然引发这个问题的根本原因是addTenThings方法没有获取锁，但是由于是日志打印，
         * 因而常常可能忽略这个锁的获取。
         *
         * 其他的如hashCode、equals、removeAll、containsAll、以容器对象为参数的构造方法，都可能调用迭代器
          */
        System.out.println("DEBUG: added ten elements to " + set);
    }

}
