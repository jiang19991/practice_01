package com.company.designPatterns.singleton;

/**
 * 静态内部类的方式
 * 饿汉式，实现了懒加载，因为外部类实例化的时候
 * 不会实例化内布列，内部类只有在使用到的时候
 * 才会实例化
 */
public class Singleton03 {
    private Singleton03(){};

    private static class Singleton03Holder{
        private static final Singleton03 INSTANCE = new Singleton03();
    }

    public static Singleton03 getInstance(){
        return Singleton03Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }

}
