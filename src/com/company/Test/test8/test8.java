package com.company.Test.test8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 姜柏宇
 * 题目8
 *仅实现了单本书的借阅记录，以及单张借阅卡的借阅情况。
 * 没有考虑同时借多本书的情况。
 */
public class test8 {
    public int bookId;
    public int count ;

    public int cardId;
    HashMap<Integer, Integer> bookMap = new HashMap<>();
    ArrayList<Integer> bookList = new ArrayList<>();
    ArrayList<Integer> cardList = new ArrayList<>();


    public static void main(String[] args) {

        test8 t = new test8();
        Book book = new Book(t.bookId,t.cardId,0);
        Card card = new Card(t.cardId);
        t.print();
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("请键入操作码：");
            int n = scanner.nextInt();
            if(n==0){
                System.out.println("感谢您的使用，再见！");
                break;
            }
            while(n!=0){

                if(n==1){
                    System.out.println("请输入进书的数量：");
                    int num = scanner.nextInt();
                    for (int i =0;i<num;i++){
                        System.out.println("请输入进书的id:");
                        t.bookId = scanner.nextInt();
                        t.ProduceBook(t.bookId);
                    }
                    System.out.print("进书完成，当前拥有的书的数量为：");
                    System.out.println(t.bookList.size());
                    System.out.println("书号分别是：");
                    for(int i : t.bookList){
                        System.out.println(i);
                    }
                    break;
                }else if(n==2){
                    System.out.println("请输入办理的借阅卡的id:");
                    t.cardId = scanner.nextInt();
                    t.HandleCard(t.cardId);
                    System.out.println("借阅卡办理成功！您的卡号id为"+ t.cardList.get(0));
                    break;
                }else if(n==3){
                    System.out.println("请输入您的借阅卡id:");
                    int borrowCardId = scanner.nextInt();
                    if (!t.cardList.contains(borrowCardId)){
                        System.out.println("对不起，请先办理借阅卡！");
                        break;
                    }
                    System.out.println("请输入所借书的id:");
                    int borrowBookId = scanner.nextInt();
                    if(!t.bookList.contains(borrowBookId)){
                        System.out.println("抱歉，我们暂时没有这本书");
                    }else{
                        t.count++;
                        t.BorrowBook(borrowBookId,borrowCardId,t.count);
                        System.out.println("借书成功!");
                        System.out.println("借书情况：");
                        for (Object key : t.bookMap.keySet()){
                            System.out.println("书号：" + key + "  借出数量：" + t.bookMap.get(key));
                        }
                    }

                    break;
                }else if (n==4){
                    System.out.println("您好，还书请先输入您的借阅卡id:");
                    int borrowCardId = scanner.nextInt();
                    if (!t.cardList.contains(borrowCardId)){
                        System.out.println("对不起，您输入的卡号不正确！");
                        break;
                    }
                    System.out.println("请输入您所还书的id:");
                    int borrowBookId = scanner.nextInt();
                    if(!t.bookList.contains(borrowBookId)){
                        System.out.println("输入错误，请检查书号后重新输入！");
                    }else{
                        t.count--;
                        t.ReturnBook(borrowBookId,borrowCardId,t.count);
                        System.out.println("还书成功!");
                        System.out.println("当前借书书情况：");
                        for (Object key : t.bookMap.keySet()){
                            System.out.println("书号：" + key + "  借出数量：" + t.bookMap.get(key));
                        }
                    }
                    break;
                }else if(n==5){
                    System.out.println("请输入需要查阅的书的id：");
                    int bookID = scanner.nextInt();
                    if(!t.bookMap.containsKey(bookID)){
                        System.out.println("没有查询到此书的借阅记录！");
                        break;
                    }
                    System.out.println("借阅记录为：");
                    for (Object key : t.bookMap.keySet()){
                        System.out.println("书号：" + key + "  借出数量：" + t.bookMap.get(key));
                    }
                    break;
                }else if(n==6){
                    System.out.println("请输入借阅卡id");
                    int borrowCardId = scanner.nextInt();
                    if (!t.cardList.contains(borrowCardId)){
                        System.out.println("对不起，该借阅卡未开通");

                    }else{
                        System.out.println("借阅记录为：");
                        for (Object key : t.bookMap.keySet()){
                            System.out.println("书号：" + key + "  借出数量：" + t.bookMap.get(key));
                        }
                    }
                    break;
                }else if (n==7){
                    System.out.println("借阅记录为：");
                    for (Object key : t.bookMap.keySet()){
                        System.out.println("书号：" + key + "  借出数量：" + t.bookMap.get(key));
                    }
                    break;
                }else{
                    System.out.println("请输入正确的操作！");
                    break;
                }

            }
            //scanner.close();
        }
    }
    public void print(){
        System.out.println("-----------欢迎来到本图书信息管理系统-----------");
        System.out.println("请输入按键进行相应的操作！");
        System.out.println("1:进书");
        System.out.println("2:办理借阅卡");
        System.out.println("3:借书");
        System.out.println("4:还书");
        System.out.println("5:查询某书的借阅记录");
        System.out.println("6:查询某卡的借阅记录");
        System.out.println("7:按借阅次数，显示图书信息");
        System.out.println("0:输入0,退出本系统！");
        System.out.println("---------------------------------------------");
        //System.out.println("请输入操作号码：");
    }

    public void ProduceBook(int bookId){

        bookList.add(bookId);

    }
    public void HandleCard(int cardId){
        cardList.add(cardId);
    }
    public void BorrowBook(int bookId,int cardId ,int count){
        if(bookMap.containsKey(bookId)){
            bookMap.put(bookId,count);
        }else{
            bookMap.put(bookId,1);
        }
    }
    public void ReturnBook(int bookId,int cardId,int count){
        bookMap.put(bookId,count);
    }
    public void RecordOfBook(int bookId){

    }
    public void RecordOfCard(int cardId){

    }
    public void bookListInfoOfBookByCount(int count){

    }


}
