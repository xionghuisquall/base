package com.leo.base.algorithm;

import com.leo.base.algorithm.helper.ArrayUtils;

import java.util.Arrays;

/**
 * Created by leo on 2017/8/17.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = ArrayUtils.makeRandomInts(10);
        System.out.println(Arrays.toString(a));

        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int min, int max) {
        if (min >= max)
            return;

        int mid = (min + max) / 2;
        mergeSort(a, min, mid);
        mergeSort(a, mid + 1, max);


        int[] left = new int[mid - min + 2];
        int[] right = new int[max - mid + 1];

        for (int i = 0; i < left.length - 1; i++) {
            left[i] = a[min + i];
        }
        left[left.length - 1] = Integer.MAX_VALUE;

        for (int i = 0; i < right.length - 1; i++) {
            right[i] = a[mid + 1 + i];
        }
        right[right.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        int count = max - min + 1;
        for (int k = 0; k < count; k++) {
            if (left[i] > right[j]) {
                a[min + k] = right[j];
                j++;
            } else {
                a[min + k] = left[i];
                i++;
            }
        }
    }
}
