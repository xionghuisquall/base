package com.leo.base.patterns.singleton;

public class P2_LazyThreadSafe {
    private static P2_LazyThreadSafe instance;

    private  P2_LazyThreadSafe() {

    }

    // 线程安全, 但由于加了锁，因此效率不高
    public synchronized static P2_LazyThreadSafe getInstance() {
        if (instance == null) {
            instance = new P2_LazyThreadSafe();
        }
        return instance;
    }
}
