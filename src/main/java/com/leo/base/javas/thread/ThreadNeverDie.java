package com.leo.base.javas.thread;

public class ThreadNeverDie {
    public static void main(String[] args) throws InterruptedException {
        // 用join可以让main线程等待自己结束，这样main线程永远不会结束
        Thread.currentThread().join();
    }
}
