package com.leo.base.algorithm.helper;

import java.util.Random;

/**
 * Created by estolia on 2017/4/30.
 */
public class ArrayUtils {
    public static int[] makeRandomInts(int length) {
        int[] a = new int[length];

        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            a[i] = r.nextInt(100);
        }

        return a;
    }
}
