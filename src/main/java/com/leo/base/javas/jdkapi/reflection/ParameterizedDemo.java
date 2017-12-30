package com.leo.base.javas.jdkapi.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 2017/12/30.
 * 获取范型参数
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

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ParameterizedDemo> clazz = ParameterizedDemo.class;
        Method method = clazz.getMethod("getCall");
        Type type = method.getGenericReturnType();
        if (type instanceof ParameterizedType) {
            System.out.println("ParameterizedType");
            ParameterizedType ptype = (ParameterizedType) type;
            System.out.println("TypeName=" + ptype.getTypeName());

            Type[] typeArgs = ptype.getActualTypeArguments();
            for (Type t : typeArgs) {
                System.out.println("args=" + t.getTypeName());
            }
        } else {
            System.out.println("Not ParameterizedType");
        }
    }
}
