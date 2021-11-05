package com.company.practice;

import org.junit.Test;

public class test222 {
    public static void main(String[] args) {
        AA bb = new BB(5);
        System.out.println("bb.flag = " + bb.flag);
        System.out.println(bb.getClass());
        System.out.println("bb.flag="+((AA)bb).flag);
    }
    @Test
    public void test(){
//        System.out.println(new DD().getValue());
        System.out.println('a'+0);
    }
}
class AA{
    int flag= 1;
    AA(){
        System.out.println("父类构造方法-this = "+ this.getClass()+"-flag="+this.flag);
        this.test();
    }
    public void test(){
        System.out.println("父类test-this = "+this.getClass()+"-flag = "+flag);
    }
}
class BB extends AA{
    int flag = 1000;
    public BB(int i){
        flag = i;
        System.out.println("子类构造");
    }
    public void test(){
        System.out.println("子类test -this="+this.getClass()+"-flag="+flag);
    }
}

class CC{
    protected int value;
    public CC(int v){
        setValue(v);
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue(){
        try{
            value++;
            return value;
        }finally {
            this.setValue(value);
            System.out.println(value);
        }
    }
}
class DD extends CC{
    public DD() {
        super(6);
        setValue(getValue()-4);

    }
    public void setValue(int value){
        super.setValue(2*value);
    }
}
class main{

}