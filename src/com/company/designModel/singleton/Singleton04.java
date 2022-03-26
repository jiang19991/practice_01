package com.company.designModel.singleton;

/**
 * 不仅可以解决线程同步问题，还可以防止反序列化
 */
public enum Singleton04 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Singleton04.INSTANCE.hashCode());
        }
    }
}
