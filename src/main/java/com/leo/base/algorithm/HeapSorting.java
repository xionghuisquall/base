package com.leo.base.algorithm;

import com.leo.base.algorithm.helper.ArrayUtils;

import java.util.Arrays;

/**
 * Created on 2017/4/30.
 *
 * 堆排序特点：
 * - unstable sort（不稳定排序）
 * - in-place sort（原址排序）
 *
 *  时间复杂度：
 * - 最好情况： O(n.lgn) ---- ???
 * - 最坏情况： O(n.lgn) ---- ???
 * - 平均情况： O(n.lgn)
 *
 *  空间复杂度：O(n)
 *
 *  使用最大堆的排序是升序
 *  使用最小堆的排序是降序
 *
 * 概括联想：
 * - 最大堆、最小堆
 * - 完全二叉树
 * - 迭代完成下面步骤：堆尾部从数组最后按每次迭代前移，树的根放入数组的堆尾部，然后维护最大（小）堆的性质
 */
public class HeapSorting {
    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int left = left(i);
        int right = right(i);

        int largest = i;

        if (left < heapSize && a[left] > a[i]) {
            largest = left;
        }

        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = a[largest];
            a[largest] = a[i];
            a[i] = tmp;
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    public static void sort(int[] a) {
        buildMaxHeap(a);

        int heapSize = a.length;

        for (int i = a.length - 1; i > 0; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            heapSize--;
            maxHeapify(a, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.makeRandomInts(10);

        System.out.println("before : " + Arrays.toString(a));

        sort(a);

        System.out.println("after  : " + Arrays.toString(a));
    }
}
