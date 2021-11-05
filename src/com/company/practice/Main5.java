package com.company.practice;

/**
 * 归并排序
 *
 * @author Jiangbaiyu
 * @version 1.0
 */
public class Main5 {
    public static void main(String[] args) {
        int[] array = {5, 2, 6, 3, 4, 1, 7, 9, 8};
        sort(array, 0, array.length - 1);
        print(array);
    }
//归并排序

    /**
     * @param array
     * @param left
     * @param right
     */
    static void sort(int[] array, int left, int right) {
        if (left == right) return;
        //将数组从中间分开
        int mid = (left + right) / 2;
        //对左半部分排序
        sort(array, left, mid);
        //对右半部分排序
        sort(array, mid + 1, right);
        //将各部分有序的数组，两两归并
        merge(array, left, mid + 1, right);
    }

    static void merge(int[] array, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;//前半部分数组的右边界
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        int[] ans = new int[rightBound - leftPtr + 1];
        //前半部分数组和后半部分数组的值逐一比较，较小的值保存在ans数组中，同时修改原数组的下标
        while (i <= mid && j <= rightBound) {
            ans[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        //如果前半部分数组有剩余
        while (i <= mid) ans[k++] = array[i++];
        //后半部分数组有剩余
        while (j <= rightBound) ans[k++] = array[j++];
        //拷贝结果到原数组中
        for (int m = 0; m < ans.length; m++)
            array[leftPtr + m] = ans[m];
    }

    static void print(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
