package com.leo.base.javas.thread.frombook.jcip.chapter5_jdkcomponent;

import java.util.concurrent.CountDownLatch;

/**
 * 展示所有线程同时开始，并且当所有线程都结束后，主线程才继续的一种例子
 */
public class TestHarness {
    public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long begin = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return  end - begin;
    }
}
