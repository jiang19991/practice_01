package com.company.exam;

import java.util.*;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        solu(array);
    }
    public static List<Integer> getMaxCount(int[] array){
        if(array==null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
        }
        int max=0;
        int ans =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet() ){
            if(entry.getValue()>max){
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    public static void solu(int[] array) {
       List<Integer> list =  getMaxCount(array);
       Map<Integer, Integer> length = new HashMap<>();
        int head=0;
        int tail=0;
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            for (int j = 0; j <array.length ; j++) {
                if(array[j]==list.get(i)){
                    head = j +1;
                    break;
                }
            }
            for (int j = array.length-1; j >=0 ; j--) {
                if(array[j]==list.get(i)){
                    tail = j+1;
                    break;
                }
            }
            length.put(list.get(i),tail-head+1);
        }
//        System.out.println(head+" "+tail);
        int min = length.get(list.get(0));
        for(Map.Entry<Integer,Integer> entry : length.entrySet()){
            min = min <entry.getValue()?min:entry.getValue();
        }
        for (Map.Entry<Integer,Integer> entry : length.entrySet()){
            if(entry.getValue()==min){
                min = entry.getKey();
                break;
            }
        }
        for (int i=0;i<array.length;i++){
            if(array[i]==min){
                head = i+1;
                break;
            }
        }
        for (int j = array.length-1; j >=0 ; j--) {
            if(array[j]==min){
                tail = j+1;
                break;
            }
        }
        System.out.println(head+" "+tail);
    }
}
