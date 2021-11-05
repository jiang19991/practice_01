package com.company.se;

import java.util.Scanner;

//public class Main000 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//                long x = scanner.nextInt();
//                long k = scanner.nextInt();
//                solu(x,k);
//        }
//    }
//    private static void solu(long x, long k) {
//        if(x==0)
//            System.out.println(0);
//        String s = "0123456789ABCDEF";
//        StringBuilder sb = new StringBuilder();
//        boolean f = false;
//        //sb循环完后保存的是k进制反转的结果
//        while(x!=0){
//            sb.append(s.charAt(x%k));
//            x /= k;
//        }
////        int temp = Integer.parseInt(sb.toString());  201   19  len =3 k =3
//        int len = sb.length();
//        long ans = 0;
//        for (int i = 0; i < len; i++) {
//            ans += Integer.parseInt(String.valueOf(sb.charAt(i))) * Math.pow(k,len-i-1);
//        }
//        System.out.println(ans);
//    }
//}
class Main0000{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        for (int i = 0; i < len; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            solu(n,m);
        }
    }

    private static void solu(int n, int m) {
        int sum =0;
        for (int i = 1; i <= n*m; i++) {
                sum += i;
        }
        sum = sum/2;
        int[][] array= new int[n][m];
        int t = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                array[i][j] = t++;
            }
        }
        int []temp=new int[n*m];
        int a=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                temp[a++] += array[i][j];
                if(a<m*n-1&&temp[a]<sum&&temp[a+1]>sum){
                    System.out.println("H" + " " + (i+1));
                }
            }
        }
        System.out.println("H" + " " + 1);
    }

}
