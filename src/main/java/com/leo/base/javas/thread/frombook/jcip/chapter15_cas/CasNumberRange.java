package com.leo.base.javas.thread.frombook.jcip.chapter15_cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 利用不变对象IntPair，以及AtomicReference一起来实现多个变量的原子操作
 */
public class CasNumberRange {
    private static class IntPair {
        final int lower;
        final int uppder;

        public IntPair(int lower, int uppder) {
            this.lower = lower;
            this.uppder = uppder;
        }
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public void setLower(int i) {
        while (true) {
            IntPair oldv =  values.get();
            if (i > oldv.uppder) {
                throw new IllegalArgumentException("illegal lower: " + i);
            }

            IntPair newv = new IntPair(i, oldv.uppder);
            if (values.compareAndSet(oldv, newv)) {
                return;
            }
        }
    }
}
