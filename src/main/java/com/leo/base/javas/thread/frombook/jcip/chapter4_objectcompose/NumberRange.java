package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 此类是线程不安全的。
 * 因为两个状态变量一起构成了对象的不变性条件，变量之间耦合、关联。
 * 同时，该类没有对两个变量施加额外的同步保护，因而虽然lower和upper
 * 两个变量分别是AtomicInteger这种线程安全的类型，但是合起来则不是线程安全的
 */
public class NumberRange {
    // 不变性条件 ： lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // 线程不安全的"先检查后执行"
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }

        lower.set(i);
    }

    public void setUpper(int i) {
        // 线程不安全的"先检查后执行"
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        }

        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
