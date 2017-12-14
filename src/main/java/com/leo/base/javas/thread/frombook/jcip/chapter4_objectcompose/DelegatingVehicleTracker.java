package com.leo.base.javas.thread.frombook.jcip.chapter4_objectcompose;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 此类是线程安全的。
 * 此例的目的：将线程安全委托给ConcurrentHashMap
 */
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        // 通过发布不可修改的map对象来保证线程安全
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        // 利用了ConcurrentHashMap中replace方法是原子操作，来提供setLocation的线程安全性
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        }
    }
}

// Point是不可变对象，因而是线程安全的
class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
