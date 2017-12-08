package com.leo.base.javas.thread;

public class ThreadJoin {
    public static void main(String[] args) {
        final Thread t1 = new Thread() {
            public void run() {
                System.out.println("t1 start...");

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("t1 running...");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    // 让t2线程等待t1执行完毕
                    t1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println("t2 running...");
            }
        };

        t1.start();
        t2.start();

    }
}
