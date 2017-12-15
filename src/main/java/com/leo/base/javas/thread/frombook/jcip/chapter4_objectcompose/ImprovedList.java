package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 此类线程安全。
 * 通过组合方式来提供putIfAbsent方法。并且其他List接口的方法都实现为synchronized。
 * 组合方式对同步的封装优于继承，因为同步逻辑集中在了一个类里面。
 * 另外，这种使用方式也假定传入构造的list对象不会在其他地方被引用到。
 * 在性能上，虽然看起来肯加了两层锁（当构造传入的list为Vector这样的同步类时），但性能还是很快的。
 * 因为封装在ImprovedList方法内的list由于没有其他线程对锁的争抢，因此很快。
 * @param <T>
 */
public class ImprovedList<T> implements List<T> {
    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T e) {
        boolean absent = !list.contains(e);
        if (absent) {
            list.add(e);
        }
        return absent;
    }

    @Override
    public synchronized int size() {
        return list.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return false;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return null;
    }

    @Override
    public synchronized Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public synchronized boolean add(T t) {
        return false;
    }

    @Override
    public synchronized boolean remove(Object o) {
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized void clear() {

    }

    @Override
    public synchronized T get(int index) {
        return null;
    }

    @Override
    public synchronized T set(int index, T element) {
        return null;
    }

    @Override
    public synchronized void add(int index, T element) {

    }

    @Override
    public synchronized T remove(int index) {
        return null;
    }

    @Override
    public synchronized int indexOf(Object o) {
        return 0;
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public synchronized ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public synchronized ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public synchronized List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
