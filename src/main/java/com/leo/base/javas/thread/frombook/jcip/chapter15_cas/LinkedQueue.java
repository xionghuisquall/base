package com.leo.base.javas.thread.frombook.jcip.chapter15_cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 基于Michael Scott 1996非阻塞算法中的插入部分。
 * 通过一些技巧，将两个看似不能用cas完成的步骤结合起来。
 * 第一个技巧是：对于包含多步的操作，也需要在多线程中保证每步的安全。具体的，如果线程B发现线程A正在执行并使数据
 * 处于中间态，那么B就不能执行自己的更新，B可以等待直到A完成后再更新自己的操作。
 * 技巧二：线程B还要帮助线程A完成它没有做完的部分，并且线程A可以发现到B的帮助并不再尝试自己做完。原则是当一个线程失败后，
 * 不会防止其他线程继续执行下去。这要求数据结构中有足够的信息使得B可以完成A的操作。
 */
public class LinkedQueue<E> {
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    // 队列处于中间状态，推进尾节点
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // 处于稳定状态，尝试插入新节点
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // 插入操作成功，尝试推进尾节点
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }
}
