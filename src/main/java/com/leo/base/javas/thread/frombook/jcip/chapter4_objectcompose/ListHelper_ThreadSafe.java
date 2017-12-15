package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 此类是线程安全的。
 * 因为list对象的锁被用于实现putIfAbsent方法，用的都是同一个锁
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
