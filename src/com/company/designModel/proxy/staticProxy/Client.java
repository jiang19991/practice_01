package com.company.designModel.proxy.staticProxy;

/**
 * 静态代理
 * 优点：在不修改目标对象的功能前提下，能通过代理对象对目标对象功能进行扩展
 * 缺点：因为代理对象需要与目标对象实现一样的接口，所以会有很多的代理类，一旦
 * 接口增加方法，目标对象与代理对象都需要维护
 */
public class Client {

    public static void main(String[] args) {

        //创建被代理的对象
        TeacherDao teacherDao = new TeacherDao();

        //创建代理的对象(将被代理对象传入)
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象调用被代理对象的方法
        //即执行代理对象的方法，间接调用被代理对象的方法
        teacherDaoProxy.teach();
    }
}
