package com.leo.base.javas.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassIdentityTest {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf("." ) + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        ClassIdentityTest obj = (ClassIdentityTest) loader.loadClass("com.leo.base.javas.jvm.ClassIdentityTest").newInstance();
    }
}
