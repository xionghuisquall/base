package com.leo.base.algorithm;

import com.leo.base.algorithm.helper.ArrayUtils;

import java.util.Arrays;

/**
 * Created on 2017/4/30.
 *
 * 插入排序特点：
 * - stable sort（稳定排序）
 * - in-place sort（原址排序）
 *
 *  时间复杂度：
 * - 最好情况： O(n)，已经排序好的情况下
 * - 最坏情况： O(n^2)，逆序的情况下
 * - 平均情况： O(n^2)
 *
 *  空间复杂度：O(n)
 *
 * 适合于数量少的元素排序
 *
 * 概括联想：
 * - 扑克牌排序
 * - 右移
 */
public class InsertionSorting {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key > a[j]) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.makeRandomInts(10);

        System.out.println("before : " + Arrays.toString(a));

        sort(a);

        System.out.println("after  : " + Arrays.toString(a));
    }
}
