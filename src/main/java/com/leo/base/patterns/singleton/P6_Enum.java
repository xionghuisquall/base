package com.leo.base.patterns.singleton;

// TODO : 还不是很理解
public class P6_Enum {
    public enum Singleton {
        INSTANCE;

        private P6_Enum instance;
        private Singleton() {
            instance = new P6_Enum();
        }

        public P6_Enum getInstance() {
            return instance;
        }
    }

    public static P6_Enum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
