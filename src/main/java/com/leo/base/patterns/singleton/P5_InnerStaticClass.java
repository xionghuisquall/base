package com.leo.base.patterns.singleton;

/**
 * 此例与P3, P4的区别在于，前者不是lazy的，其中的instance随着类加载而初始化。
 * 而这里由于使用了内部静态类，因而P5_InnerStaticClass加载时SingletonHolder不加载，
 * 在显式调用getInstanc方法时由于使用到了SingletonHolder，此时才会加载SingletonHolder，
 * 并且由于类加载是线程安全的，所以同时达到了lazy和thread safe的目的
 */
public class P5_InnerStaticClass {
    private static class SingletonHolder {
        private static final P5_InnerStaticClass instance = new P5_InnerStaticClass();
    }

    private P5_InnerStaticClass() {}

    public static P5_InnerStaticClass getInstance() {
        return SingletonHolder.instance;
    }
}
