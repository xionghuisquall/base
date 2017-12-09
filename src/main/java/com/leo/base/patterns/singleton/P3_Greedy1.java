package com.leo.base.patterns.singleton;

// 线程安全
public class P3_Greedy1 {
    private static P3_Greedy1 instance = new P3_Greedy1();

    private P3_Greedy1() {

    }

    public static P3_Greedy1 getInstance() {
        return instance;
    }
}
