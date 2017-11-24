package com.leo.base.algorithm;

import com.leo.base.algorithm.helper.ArrayUtils;

import java.util.Arrays;

/**
 * Created by leo on 2017/8/17.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = ArrayUtils.makeRandomInts(10);
        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }
}
