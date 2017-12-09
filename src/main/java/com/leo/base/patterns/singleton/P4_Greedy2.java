package com.leo.base.patterns.singleton;

// P3_Greedy1 的变种，本质上一样
public class P4_Greedy2 {
    private static P4_Greedy2 instance = null;

    static {
        instance = new P4_Greedy2();
    }

    private P4_Greedy2() {}

    public static P4_Greedy2 getInstance() {
        return instance;
    }
}
