package com.company.designModel.proxy.staticProxy;

public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理开始。。。");
        target.teach();
        System.out.println("代理结束。。。");
    }
}
