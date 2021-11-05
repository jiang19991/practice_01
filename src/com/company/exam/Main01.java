package com.company.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nums = scan.nextLine();
        int num = Integer.parseInt(nums);
        for (int i = 0; i < num; i++) {
            ArrayList<String> list = new ArrayList<>();
            String str = scan.nextLine();
            solu(str.toCharArray(),list);
        }

    }
    public static void solu(char[] array,ArrayList<String> list ){
        recursion(array,0,array.length-1,list);
        for (int i = 0; i < list.size(); i++) {
            if(isResverse(list.get(i))==false){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    //字符串全排列
    public static void recursion(char[] array,int start,int end,ArrayList<String> list){
        if(end<=1)
            return ;
        if(start==end){
                list.add(new String(array));
        }else{
            for (int i = start; i <= end ; i++) {
                swap(array,i,start);
                recursion(array,start+1,end,list);
                swap(array,i,start);
            }
        }
    }
    public static void swap(char[]array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //判断回文
    public static boolean isResverse(String s){
        if(s==null||s.length()==0)
            return false;
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}
