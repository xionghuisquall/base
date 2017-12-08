package com.leo.base.javas.thread;

public class ObjectWaitNotifyAll {
    public static void main(String[] args) {
        final Object monitor = new Object();
        for (int i = 0; i < 5; i++) {
            final Thread t = new Thread("thread-" + i) {
                public void run() {
                    int j = 0;
                    while (true) {
                        synchronized (monitor) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                System.out.println(this.getName() + " interrupted");
                            }
                        }

                        System.out.println(this.getName() + " do sth..." + j++);
                    }
                }
            };

            t.start();
        }

        for (int i = 0; i < 10; i++) {
            synchronized (monitor) {
                monitor.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }


        }
    }
}
