package com.company.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 姜柏宇
 * 题目四
 */
public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = scanner.nextLine();
        Calc(s);
        scanner.close();
    }

    public static int Calc(String str) {
        //两个双端队列，分别存储数字和运算符
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Character> linkedList2 = new LinkedList<>();
        char[] chars = str.toCharArray();
        int n = chars.length;
        int temp = 0;
        //数字和运算符分别入队
        for (int i = 0; i < n; i++) {

            if (chars[i] >= '0' && chars[i] <= '9') {
                temp = temp * 10 + Integer.parseInt(String.valueOf(chars[i]));

            } else {

                linkedList1.offerLast(temp);
                temp = 0;
                if (i != n - 1) {
                    linkedList2.offer(chars[i]);
                }
            }
            if (i == n - 1) {
                linkedList1.offerLast(temp);
                temp = 0;
            }

        }
        //计算
        int ans = 0;
        while (!linkedList1.isEmpty() && !linkedList2.isEmpty()) {
            char ch = linkedList2.poll();
            int t = 0;
            switch (ch) {
                case '+':
                    t = linkedList1.removeFirst() + linkedList1.removeFirst();
                    break;
                case '-':
                    t = linkedList1.removeFirst() - linkedList1.removeFirst();
                    break;
                case '*':
                    t = linkedList1.removeFirst() * linkedList1.removeFirst();
                    break;
                case '/':
                    t = linkedList1.removeFirst() / linkedList1.removeFirst();
                    break;
                default:
            }
            ans = t;
            linkedList1.offerFirst(t);
        }
        System.out.println(ans);
        return ans;
    }
}
