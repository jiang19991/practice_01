package com.company.codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Prac06 {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        solu(array);
    }

    public static List<List<Integer>> solu(int[] array) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (array == null || array.length < 3)
            return ans;
        Arrays.sort(array);
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[0] > 0)
                break;
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while(left<right){
                int sum = array[i]+array[left]+array[right];
                if(sum==0){
                    list.add(array[i]);
                    list.add(array[left]);
                    list.add(array[right]);
                    ans.add(new ArrayList(list));
                    list.clear();
                    while(left<right&&array[left]==array[left+1])
                        left++;
                    while (left<right&&array[right]==array[right-1])
                        right++;
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else
                    left++;
            }
        }
        System.out.println(ans.toString());
        return ans;
    }
}
