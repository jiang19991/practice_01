package com.company.designPatterns.proxy.dynamicProxy;

/**
 * 动态代理
 * 1.代理对象不需要实现接口，目标对象需要实现接口，否则不能使用动态代理
 * 2.代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象
 * 3.动态代理也叫JDK代理，接口代理
 *
 */
public class Client {

    public static void main(String[] args) {
        //创建目标对象（被代理对象）
        ITeacherDao target = new TeacherDao();

        //给目标对象创建代理对象，可以转成ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        //这时proxyInstance就是动态生成的代理对象
        System.out.println("proxyInstance " + proxyInstance.getClass());

        //通过代理对象，调用目标对象方法
        proxyInstance.sayHello("姜柏宇");
        proxyInstance.play();


        //ceshi111
    }

}
