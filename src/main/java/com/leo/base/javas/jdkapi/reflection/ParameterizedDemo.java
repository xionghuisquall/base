package com.leo.base.javas.jdkapi.reflection;

/**
 * Created by estolia on 2017/12/30.
 */
public class ParameterizedDemo {
    static interface Call<T> {
        T execute();
    }

    public Call<Runnable> getCall() {
        return new Call<Runnable>() {
            @Override
            public Runnable execute() {
                return null;
            }
        };
    }

    public static void main(String[] args) {

    }
}
