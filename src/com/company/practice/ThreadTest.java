package com.company.practice;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        m7();
    }
    public static void test1(){
        Thread t0 = new Thread();
        Thread t = new MyThread();
        //启动执行该子线程，执行线程run方法，立刻返回start方法
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("test"+i);
        }
    }
    public static void test2(){
        Thread t = new Thread(){
            public void run(){
                System.out.println("Thread Running");
            }
        };
        t.start();
    }

    public static void m3(){
        //为了使线程能够执行run方法，
        //需要在Thread类的构造函数中传入MyThread的实例对象
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
    public static void m4(){
        Runnable target = new MyRunnable();
        Thread thread = new Thread(target,"线程1");
        System.out.println(thread.getName());
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
//        thread.start();
    }
    public static void m5(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 匿名内部类的方式创建的线程启动了");
            }
        });
        thread.start();
    }
    public static void m6(){
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方式创建的线程启动了");
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    public static void m7(){
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            new Thread("a"+i){
                @Override
                public void run() {
                    System.out.println(getName());
                }
            }.start();
        }
    }




}

class MyRunnable implements Runnable{
    @Override
    public void run() {
//        System.out.println("实现Runnable接口的方式创建的线程启动了");
    }
}

class MyTest2{
    public static void main(String[] args) {
        System.out.println("22---"+new Date().toLocaleString());
        Timer t = new Timer();
        t.schedule(new TimerTask(){

            @Override
            public void run() {
                System.out.println("11---"+new Date().toLocaleString());
            }
        },5000,1000);

    }
}

class MyTest3{
    public static void main(String[] args) throws InterruptedException {
//        Runnable MyRunnable = new MyRunnable();
//        Runnable MyRunnable2 = new MyRunnable();
//        Thread t1 = new Thread(MyRunnable);
//        Thread t2 = new Thread(MyRunnable2);
        Runnable MyRunnable3 = new MyRunnable();
        Thread t1 = new Thread(MyRunnable3,"线程A");
        Thread t2 = new Thread(MyRunnable3,"线程B");
        ss1();
    }
    private static synchronized void ss1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        }
    }

    private void ss2() throws InterruptedException {
        System.out.println("132");
        synchronized (this){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        }
    }
}


class ThreadPoolTest{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //将任务扔到线程池的四种方式
        //使用匿名内部类的方式
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"正在运行");
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

/**
 * 生产者消费者问题
 */
class ThreadPool{
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread thread1 = new Thread(producer);
        thread1.setName("生产者");
        Thread thread2 = new Thread(consumer);
        thread2.setName("消费者1");
        Thread thread3 = new Thread(consumer);
        thread3.setName("消费者2");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static class  Clerk{
        int productNums = 0;
        int consumerNums = 0;
        public Clerk() {
        }

        public synchronized void addProduct() throws InterruptedException {
            if(productNums>200){
                wait();
            }else{
                productNums = productNums+10;
                System.out.println(Thread.currentThread().getName()+":生产了"+productNums+"件商品");
                notifyAll();
            }
        }
        public synchronized void getProduct() throws InterruptedException {
            if(productNums<=0){
                wait();
            }else{
                consumerNums++;
                System.out.println(Thread.currentThread().getName()+":消费了"+consumerNums+"件商品");
//                productNums = productNums-1;
                notifyAll();
            }
        }
    }

    static class Producer implements Runnable{
        public  Clerk clerk;

        public Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    clerk.addProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer implements Runnable{
        public    Clerk clerk;
        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    clerk.getProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

