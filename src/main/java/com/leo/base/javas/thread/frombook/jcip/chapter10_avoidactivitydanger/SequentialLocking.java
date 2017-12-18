package com.leo.base.javas.thread.frombook.jcip.chapter10_avoidactivitydanger;

/**
 * 通过锁顺序来避免死锁。
 * 具体的，通过比较hash值大小来保证顺序一致的加锁（因为外部调用者可能在多个线程中调和入参的fromAccount和toAccount的顺序，导致死锁）。
 * 当极小的情况两个hash值一样时，通过第三个锁tieLock来避免死锁。
 */
public class SequentialLocking {
    private final static Object tieLock = new Object();

    public void transferMoney(final Account fromAccount, final Account toAccount, final double amout) {
        class Helper {
            public void transfer() {

            }
        }

        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    private static class Account {

    }
}
