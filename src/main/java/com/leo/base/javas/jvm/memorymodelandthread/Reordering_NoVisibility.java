package com.leo.base.javas.jvm.memorymodelandthread;

/**
 * 此例来自《java并发编程实战》by brian goetz。
 * 由于下面的代码缺乏同步措施，在指令重排reordering的影响下，
 * 可能导致多种错误的结果，虽然不一定出现的很频繁。例如：
 * 1、while循环永不退出
 * 2、打印的值是0而不是42
 */
public class Reordering_NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
