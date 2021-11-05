package com.company.designModel.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){

        //利用反射，动态的在内存中构建代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("JDK代理开始。。。");
                        Object res = method.invoke(target,args);//这里会调用目标对象的方法
                        System.out.println("JDK代理结束。。。");
                        return res;

                    }
                });
    }
}
