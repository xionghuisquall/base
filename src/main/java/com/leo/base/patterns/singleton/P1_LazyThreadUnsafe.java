package com.leo.base.patterns.singleton;

public class P1_LazyThreadUnsafe {
    private static P1_LazyThreadUnsafe instance;

    private  P1_LazyThreadUnsafe() {

    }

    // 线程不安全
    public static P1_LazyThreadUnsafe getInstance() {
        if (instance == null) {
            instance = new P1_LazyThreadUnsafe();
        }
        return instance;
    }
}
