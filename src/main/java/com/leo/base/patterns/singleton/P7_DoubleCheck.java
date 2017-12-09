package com.leo.base.patterns.singleton;

/**
 * 其中的volatile是关键，用于避免jvm进行优化后造成的指令乱序。
 * 不过要做jdk1.5开始后volatile关键字的此性质才能生效。之前的是没有禁止指令重排序的。
 */
public class P7_DoubleCheck {
    private static volatile  P7_DoubleCheck instance = null;

    private P7_DoubleCheck() {}

    public static P7_DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (P7_DoubleCheck.class) {
                if (instance == null) {
                    instance = new P7_DoubleCheck();
                }
            }
        }

        return instance;
    }
}
