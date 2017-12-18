package com.leo.base.javas.thread.frombook.jcip.chapter5_jdkcomponent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskRunnable implements Runnable {
    private BlockingQueue<Task> queue = new LinkedBlockingQueue();

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            /**
             * 对抛出的InterruptedException一般有两种处理办法。
             * 1、传递异常。
             * 即往上抛给调用者。抛出前，可选择的进行一些简单的清理工作。
             *
             * 2、!! 恢复被中断的状态。
             * 通过调用当前线程的interrupt方法对中断进行恢复。如下面这样。
             * 这样调用栈中的更高层代码将看到这个中断。
             *
             * 最不应该做的是，捕获了异常但是什么都不做，因为更高层的代码将无法
             * 对中断做出响应，因为中断的证据已经丢失。
             */
            Thread.currentThread().interrupt();
        }
    }

    private void processTask(Task t) {

    }

    private static class Task {

    }
}
