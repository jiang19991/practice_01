package com.company.designModel.proxy.dynamicProxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public void play() {
        System.out.println("玩呀玩~~~");
    }
}
