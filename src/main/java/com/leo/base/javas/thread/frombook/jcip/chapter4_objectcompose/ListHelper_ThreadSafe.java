package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 此类是线程安全的。
 * 因为list对象的锁被用于实现putIfAbsent方法，用的都是同一个锁.
 * 但是这样很脆弱，包括另一种通过继承实现的同步方法也是，因为同步逻辑
 * 分处不同的类中，很容易被破坏掉。
 * @param <E>
 */
public class ListHelper_ThreadSafe<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E e) {
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }
}
