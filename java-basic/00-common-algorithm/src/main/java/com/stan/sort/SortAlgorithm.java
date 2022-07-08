package com.stan.sort;

import java.util.Arrays;

/**
 * 最热门的五种排序算法：
 * 插入排序： 直接插入排序
 * 交换排序：冒泡排序、快速排序
 * 选择排序：直接选择排序
 * 归并排序：二路归并排序
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 1, 5, 2};
        printArr(arr, "before");
        quickSort(arr, 0, arr.length - 1);
        printArr(arr, "after");

//        printArr(arr, "before");
//        bubbleSort(arr);
//        printArr(arr, "after");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int m = quickSortPartition(arr, low, high);
        printArr(arr, "------->");
        quickSort(arr, low, m - 1);
        quickSort(arr, m + 1, high);
    }

    public static int quickSortPartition(int[] arr, int low, int high) {
        int p = arr[low];
        while (low < high) {
            // 从右往左找到第一个大于p的位置
            while (low < high && arr[high] > p) high--;
            arr[low] = arr[high];

            // 从左往右找到第一个小于p的位置
            while (low < high && arr[low] < p) low++;
            arr[high] = arr[low];
        }
        arr[low] = p;
        return low;
    }

    /**
     * 选择排序：选择最小记录放左边
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(String.format("第%d趟：", i + 1));
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j; // 选出最小值
            }
            if (min != i) swap(arr, min, i);
            printArr(arr, "selectSort", i, 0);
        }
    }

    /**
     * 冒泡排序：两两相比较，将较大值交换到顶端
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 控制循环次数
            boolean endSort = true;
            System.out.println(String.format("第%d趟：", i + 1));
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    endSort = false;
                }
                printArr(arr, "bubbleSort", i, j);
            }
            if (endSort) break;
        }
    }

    /**
     * 冒泡排序--自己写的有问题？
     */
    public static int[] bubbleSort_err(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                printArr(arr, "bubbleSort", i, j);
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }

        return null;
    }

    /**
     * 交换数组元素
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static void printArr(int[] arr, String flag) {
        System.out.println(flag + ": " + Arrays.toString(arr));
    }

    private static void printArr(int[] arr, String flag, int i, int j) {
        System.out.println(flag + " i=" + i + " j=" + j + ": " + Arrays.toString(arr));
    }
}
