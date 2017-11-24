package com.leo.base.algorithm;

import com.leo.base.algorithm.helper.ArrayUtils;

import java.util.Arrays;

/**
 * Created by leo on 2017/8/17.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = ArrayUtils.makeRandomInts(10);
        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
