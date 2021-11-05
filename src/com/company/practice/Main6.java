package com.company.practice;

public class Main6 {
    //快速排序
    public static void main(String[] args) {
        int[] array = {4, 6, 5, 7, 8, 3, 5, 1, 6, 9};
        sort(array, 0, array.length - 1);
        print(array);
    }

    private static void sort(int[] array, int leftBound, int rightBound) {
        //如果左边界大于右边界，直接返回
        if (leftBound > rightBound) return;
//        获取当前的轴
        int mid = partition(array, leftBound, rightBound);
        //递归的对轴左侧进行排序
        sort(array, leftBound, mid - 1);
        //对轴右侧进行排序
        sort(array, mid + 1, rightBound);
    }

    static int partition(int[] array, int leftBound, int rightBound) {
        //以最右的元素为轴
        int pivot = array[rightBound];
        //左指针从第一个元素开始
        int left = leftBound;
        //右指针从倒数第二个元素开始
        int right = rightBound - 1;
        while (left < right) {
            //从左开始，当前元素小于或者等于轴，则左指针右移到下一个位置
            while (left <= right && array[left] <= pivot) left++;
            //从右指针开始，如果当前元素大于轴，则右指针左移到下一个位置
            while (left <= right && array[right] > pivot) right--;
//          否则，如果以上两种情况都不满足，即出现左指针所指元素大于轴，右指针所指元素小于等于轴，则交换左右指针所指的元素
            if (left < right) swap(array, left, right);
        }
        //交换轴和当前左指针所指元素，交换后使得当前左指针所指元素，左边的都比他小，右边的都比他大
        swap(array, left, rightBound);
        //返回当前左指针，即轴
        return left;

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
