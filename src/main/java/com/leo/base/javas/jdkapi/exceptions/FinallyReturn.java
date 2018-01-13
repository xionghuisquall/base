package com.leo.base.javas.jdkapi.exceptions;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

public class FinallyReturn {
    public static void main(String[] args) {
        try {
            test(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test(int flag) {
        try {
            if (flag == 1) {
                System.out.println("throw");
                throw new IOException("AAA");
            }
        } finally {
            System.out.println("in finally");
            // !!加上return后，上面的IOException就丢失了，并且方法签名上也不需要再写throws IOException
            return;
        }
    }
}
