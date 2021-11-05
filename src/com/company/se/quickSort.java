package com.company.se;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * 快速排序非递归版
 */
public class quickSort  {

    public static void main(String[] args) {
        int[] num = {4, 6, 5, 7, 8, 3, 5, 1, 6, 9};
        sort1(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    public static void Push(LinkedList<Integer> stack, int left, int right) {
        stack.push(left);
        stack.push(right);
    }

    public static int partation(int[] num, int left, int right) {
        int pivot = num[right];
        int l = left;
        int r = right - 1;
        while (l <= r) {
            while (l <= r && num[l] <= pivot) l++;
            while (l <= r && num[r] > pivot) r--;
            if (l <= r)
                swap(num, l, r);
        }
        swap(num, l, right);
        return l;
    }
    //递归
    public static void sort1(int[] num, int left, int right) {
        if(left>right)
            return;
        int mid = partation(num,left,right);
        sort(num,left,mid-1);
        sort(num,mid+1,right);
    }
    //非递归
    public static void sort(int[] num, int left, int right) {
        LinkedList<Integer> st = new LinkedList<>();
        Push(st, left, right);
        while (!st.isEmpty()) {
            int r = st.pop();
            int l = st.pop();
            if (l >= r) continue;
            int mid = partation(num, l, r);//找到mid使得mid左边都比num[mid]小，右边都比他大
            Push(st, l, mid - 1);
            Push(st, mid + 1, r);
        }
    }

    public static void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
