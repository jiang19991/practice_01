package com.company.designModel.singleton;

/**
 * 懒汉式
 * 按需实例化，但线程不安全
 */
public class Singleton02 {

    private static volatile Singleton02 INSTANCE;

    private Singleton02(){}

    public static Singleton02 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }
    //synchronized保证线程安全
    public static synchronized Singleton02 getInstance01(){
        if(INSTANCE==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Singleton02.getInstance01().hashCode());
            }).start();
        }
    }
}
