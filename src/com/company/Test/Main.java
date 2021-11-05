package com.company.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

//public class Main {
//
//    public static List<List<Integer>> solu(TreeNode t){
//        List<List<Integer>> ans = new ArrayList<>();
//        List<TreeNode> list = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if(t==null){
//            return ans;
//        }
//        int start = 0;
//        int end =1;
//        queue.add(t);
//        while(!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            list.add(temp);
//            start++;
//            if(temp.left!=null){
//                queue.add(temp.left);
//            }
//            if(temp.right!=null){
//                queue.add(temp.right);
//            }
//            if(start==end){
//                ans.add(new ArrayList<>(list));
//                start=0;
//                end = queue.size();
//                list.clear();
//            }
//        }
//        return ans;
//    }
//}
import java.util.*;
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int data){
        this.val = data;
    }
}
public class Main{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        ListNode head = new ListNode(0);
        ListNode phead = head;
        for(int i=0;i<arr.length;i++){
//            System.out.println(head.val);
            ListNode node = new ListNode(arr[i]);
            head.next =node;
            head = head.next;
        }
//        ListNode h = phead.next;
//        while (h!=null){
//            System.out.print(h.val);
//            h = h.next;
//        }
        ListNode  ans = solu(phead.next,k);
        while (ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }

    private static ListNode solu(ListNode head, int k) {
        if(head==null||k<1)
            return  head;
        ListNode temp = head;
        int num =0;
        while(temp!=null){
            num++;
            temp = temp.next;
        }
        if(k==1){
            return  head.next;
        }
        if(k>num){
            return head;
        }
        
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = head;
        int n =0;
        while(n++ < k-1){
            node = node.next;
            pre = pre.next;
        }
        pre.next = node.next;
        return head;
    }
}
