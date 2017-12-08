package com.leo.base.javas.thread;

public class ThreadForceClose {
    public static void main(String[] args) {
        ThreadService ts = new ThreadService();
        long begin = System.currentTimeMillis();
        ts.execute(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("task running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        String s = "wefwefwefwefwfewewfwefwefwfeweff";

        /**
         * 从汪文君的视频第一部分17讲看到此例子。用于控制一个线程在执行超过指定时间后强制停止。
         * 但此方法并不实用，因为被控制的线程处于daemon线程，这时如果加入下面的t3线程，则到时间点后，runner还是会继续执行。达不到超时停止的目的。
         * 改进的办法是，不应该把runner设置为daemon，而是应该设置为当execute线程结束后就结束的线程，似乎可以考虑用线程组？？
         */
//        Thread t3 = new Thread() {
//            public void run() {
//                int i = 10;
//                while (i > 0) {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//
//                    }
//                }
//
//                System.out.println("t3 finished");
//            }
//        };
//        t3.start();

        ts.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}

class ThreadService {
    private Thread execute;

    private boolean finish = false;

    public void execute(final Runnable task) {
        execute = new Thread() {
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();
                try {
                    runner.join();
                } catch (InterruptedException e) {
                    System.out.println("execute interrupted");
                }

                finish = true;
            }
        };

        execute.start();


    }

    public void shutdown(long time) {
        long current = System.currentTimeMillis();
        while (!finish) {
            if (System.currentTimeMillis() - current >= time) {
                System.out.println("execute overtime");
                execute.interrupt();
                break;
            }
        }
    }
}
