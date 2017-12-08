package com.leo.base.javas.thread;

import java.util.stream.Stream;

/**
 * 这个例子中的notify不一定能notify到wait中的consumer，而是notify到了wait中的producer。
 * 因而会出现hang住的情况
 */
public class ProducerConsumerHangOver {
    final Object LOCK = new Object();
    private volatile boolean isProduced = false;

    private int i = 0;

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println(Thread.currentThread().getName() + " wait");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                isProduced = true;
                LOCK.notify();
//                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                isProduced = false;
                LOCK.notify();
//                isProduced = false;
            } else {
                System.out.println(Thread.currentThread().getName() + " wait");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerHangOver pc = new ProducerConsumerHangOver();

        Stream.of("P1", "P2").forEach(n -> new Thread(n) {
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start());

        Stream.of("C1", "C2").forEach(n -> new Thread(n) {
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start());
    }
}
