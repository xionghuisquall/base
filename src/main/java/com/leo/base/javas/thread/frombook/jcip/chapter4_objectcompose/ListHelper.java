package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 此类是线程不安全的。
 * 因为list对象的锁和ListHelper对象的锁是两个不同的锁
 * @param <E>
 */
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E e) {
        boolean absent = !list.contains(e);
        if (absent) {
            list.add(e);
        }
        return absent;
    }
}
