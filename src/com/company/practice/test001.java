package com.company.practice;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.practice.Main6.print;

public class test001 {
    public static void main(String[] args) {

    }

    public void functionA(int[] array, int k) {
        //array = new int[6,7,8,9];这里取消注释则，传递过来的参数改数无效
        //因为这里对参数重新赋值了，是另外一个地址的引用
        for (int i = array.length; i >= 0; i--) {
            array[i] *= 2;
        }
        k += 5;
        System.out.println("\nk=" + k);
    }



    @Test
    public void functionB() {
        int[] array = {1, 2, 3, 4};
        System.out.println("-------未传递前数组元素为：");
        print(array);
        int t = 2;
        functionA(array, t);//array引用传递，t值传递
        System.out.println("\nt = " + t + "\n+++++++已传递后数组元素为：");
        print(array);//2,4,6,8

    }

    @Test
    public void test() {
        String name = new String("bes");
        char[] product = {'d', 'x', 'p'};
        Integer i = 10;
        change(name, product, i);
        System.out.println(name + '\t' + new String(product) + '\t' + i);
    }

    private void change(String name, char[] product, Integer i) {
        name = "Changed";
        i = 100;
        product[1] = 'a';
    }

    int[][] array31;
    int array32[][];
    int[] array33[];

    int[][] arrr41 = new int[2][3];
    int[][] arrr42 = new int[][]{{1, 2, 3}, {7, 8, 9}};
    int[][] arrr43 = {{1, 2, 3}, {7, 8, 9}};

    int[][] arrr44 = new int[2][];
    int[] aa1 = arrr44[0];
    int[][] aa2 = new int[][]{};

    @Test
    public void test1() {
        System.out.println(arrr44[0]);
        System.out.println(new int[2]);
        System.out.println(aa2);
    }

//    @Test
//    public void test2(){
//        int [] array3 = new int[len];
//        System.arraycopy(array1,0,array3,len);
//        //第一个参数：来源数组的名称
//        //第二个参数：来源数组的起始位置
//        //第三个参数：目的数组的名称
//        //第四个参数：目的数组的起始位置
//        //第五个参数：来源数组中需要复制元素的个数
//        System.out.println("复制后array3中的元素为：");
//        Arrays.toString(array3);
//    }

    //    public void function3(){
//        int[] array4 = Arrays.copyOf(array1,len-2);
//        System.out.println("复制后array4中的元素为");
//        for(int i : array4)
//            System.out.println(i+"\t");
//        System.out.println();
//        System.out.println(array4);
//        System.out.println(Arrays.toString(array4));
//    }
    @Test
    public void test3() {
        int[] array = new int[5];
        Arrays.fill(array, 1);
        System.out.println("输出数组第一次填充后的元素：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        //向数组中索引号是[1,3)的元素进行填充9
        Arrays.fill(array, 1, 3, 9);
        System.out.println("输出数组第二次填充后的元素：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("数组长度：" + array.length);
    }

    @Test
    public void test4() {
        String[] array = {"aaa", "bbb", "ccc", "ddd", "eee"};
        int index1 = Arrays.binarySearch(array, "eee");
        System.out.println("查找eee的位置是：" + index1);
        System.out.println(array[index1]);
        int index2 = Arrays.binarySearch(array, "fff");
        System.out.println("查找fff的位置是：" + index2);
    }

    @Test
    public void test5() {
//        Arrays.sort(array);
////        数值默认排序：升序
////        字符串排序默认：先大写，后小写
//
//        Arrays.sort(array,String.CASE_INSENSITIVE_ORDER)；
////        按字母表顺序排序（不敏感）
//
//        Arrays.sort(aa2, Collections.reverseOrder());
////        反向排序
//
//        Arrays.sort(array,String.CASE_INSENSITIVE_ORDER);
//        Collections.reverse(Arrays.asList(strArray));
    }

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
//        for(B:A){C}
//        A:线性集合或数组
//        B：元素类型 变量名（迭代遍历是每个元素）
        for (Integer i : list)
            System.out.println(i);
    }

    @Test
    public void test7() {
        //判空字符串：长度为0，有无对象null
        //判空集合：元素个数为0，有无对象null
        ArrayList<String> a1 = null;
        ArrayList<String> a2 = new ArrayList<>();
        System.out.println(a1 == null);
        System.out.println(a1 == a2);
        System.out.println(a2.size());
        System.out.println(a2.isEmpty());
        if (a2 == null || a2.isEmpty()) {

        }
        if (a2 != null && !a2.isEmpty()) {

        }
    }
    @Test
    public void test8(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("ee");
        list.add("ff");
        for (String p:list) {
            System.out.println("----"+p);
            if("cc".equals(p)){
                list.remove(p);
                //break;
            }
        }
        System.out.println(list);
    }
    @Test
    public void test9(){
        LinkedList<String> list = new LinkedList<>();
        list.add("123");
        list.add("234");
        list.add("345");
        System.out.println(list);
        String s= list.get(2);
        System.out.println(s);
        s = list.peek();//返回队列头部的元素，队列为空时返回
        System.out.println(s);
        System.out.println(list);
        s = list.poll();//返回并移除队列的头部元素，队列为空时返回
        System.out.println(s);
        System.out.println(list);
        s = list.pop();//弹出一s个元素
        System.out.println(s);
        System.out.println(list);
        list.push("111111111");//推入一个元素
        System.out.println(list);
    }
    @Test
    public void test10(){
        HashSet<String> set = new HashSet<String>();
        for(String s : set){//遍历
            System.out.println(s);
        }
        Iterator<String> it = set.iterator();
        while(it.hasNext()){//迭代器
            System.out.println(it.next());
        }
    }
    @Test
    public void test11(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("a");
        treeSet.add("f");
        treeSet.add("b");
        treeSet.add("e");
        treeSet.add("f");
        System.out.println(treeSet);
        //compareTo 返回int结果
        System.out.println("a".compareTo("b"));
        System.out.println("a".compareTo("a"));
        System.out.println("b".compareTo("a"));
        for(String s : treeSet){
            System.out.print(s+" ");
        }
    }
    //测评题第三题
    @Test
    public void test12(){
        int[]  a= {1,4,9,6,5};
        for (int i = 1; i < 9; i++) {
            for(int c:a){
                int k = i*1100+c*11;
                int n = (int) Math.sqrt(k);
                if(n*n==k){
                    System.out.println(k);
                }
            }
        }
    }
    //第九题
    @Test
    public void getArray(){
        int n =3;
        int[][] array = new int[n][n];
        for (int i=0;i<n*n;i++){
            array[i/n][i%n] = i+1;
        }
        print1(array,-1,0,n,1);
    }

    /**
     *
     *
     * @param array
     * @param i 横向
     * @param i1 纵向
     * @param n 每行遍历个数
     * @param i2 偏移正负
     */
    private void print1(int[][] array, int i, int i1, int n, int i2) {
        for (int k =1;k<=n;k++)
            System.out.println(array[i1][i+i2*k]);
        if(--n==0)
            return;
        for (int k =1;k<=n;k++){
            System.out.println(array[i1+i2*k][i+i2*(n+1)]);

        }
        print1(array,i+i2*(n+1),i1+i2*n,n,-i2);
    }

//    public void calc(String s){
//        //将所有的非数字字符串替换为逗号
//        s = s.replaceAll("[^0-9]",",");
//        String [] strings = s.split(",");
//        print(strings);
//    }

//    public void a5(){
//        Animal a = new Animale();//Animal类型的变量，Animal类型的对象
//        Animal c = new Dog();//Animal类型的变量，Dog类型的对象
//        //向上转型
//        int t0 = 100;
//        long t1 = t0;
//        //向下转型--需要进行强制类型转换
//        int t2 = (int)t1;
//
//        Dog e = (Dog) c;//向下转型-强制类型转换
//
//        //Dog f = (Dog) a;//向下转型-ClassCastException异常
//    }

//    public void a4(){
//        Animal a = new Animal();
//        Dog b = new Dog();
//        Animal c = new Dog();
//        Object d = new Dog();
//        System.out.println(b instanceof Dog);
//        System.out.println(d instanceof Dog);
//        System.out.println(d instanceof  Animal);
//        System.out.println(a instanceof Dog);
//        System.out.println(c instanceof Dog);
//        System.out.println(a.p);
//        System.out.println(b.p);
//        System.out.println(c.p);
//    }
//    public void test111(){
//        System.out.println(b);
//        //实例方法中使用当前类的静态成员时
//        System.out.println(a);
//        System.out.println(this.a);
//        System.out.println(TestStatic1.a);
//        //1.实例方法中的成员默认时当前对象来调用，即this.b
//        //2.对象调用静态成员与类调用静态成员作用相同，即TestStatic1.b
//        //--即调用该实例方法的对象来调用静态成员
//    }
//    public void test112(){
//        System.out.println(b);可以直接调用当前类的实例成员，只能使用标准的调用格式
//        //静态方法中的成员默认是类来调用的，即：类名.成员
////        System.out.println(this.b);
//        //类在未实例化对象时即可使用静态成员，因此静态方法中不可使用this关键字
//        //静态方法中不
//    }

    {
        System.out.println(100);
    }
    static {
        System.out.println(200);
    }



}
//class A{
//    A(){
//        System.out.println("AA");
//    }
//}
//class B extends  A{
//    B(){
//        System.out.println("BB");
//    }
//}
//class E{
//    private static void testMethod(){
//        System.out.println("testMethod");
//    }
//    private  void test(){
//
//    }
//
//    public static void main(String[] args) {
//        ((E)null).testMethod();
//        E e1 = (E)null;
//        e1.testMethod();
//        E e2 = null;
//        e2.testMethod();
//    }
//}
class Demo1{
    static int a;
    static {
        a=11;
        System.out.println(a+"+++");
    }
    int b ;
    {
        b=12;
        System.out.println(b+"+++");
    }

    public static void main(String[] args) {
        System.out.println(a+"---");
        System.out.println(new Demo1().b+"---");
    }
}

class Demo2{
    static {
        a =21;
//        System.out.println(a);
    }
    static int a;
    {
        b=22;
//        System.out.println(b);
    }
    int b ;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(new Demo2().b);;
    }
}

class Demo3{
    static {
        a = 21;
        System.out.println(3);
    }
    static int a =31;
    {
        b = 22;
    }
    int b =32;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(new Demo3().b);
    }
}

class TestStatic04{
    static {
        x =5;
    }
    static int x,y;

    public static void main(String[] args) {
        x--;
        test();
        System.out.println(x + y + ++x);//6+10+7
    }

    private static void test() {
        y = x++ + ++x;
    }
}

class A{
    public A(){
        System.out.println("----aa");
    }
    public void a12(){
        System.out.println("----a12");
    }
    public static void a22(){
        System.out.println("----a22");
    }
    {
        System.out.println("----a13");
    }
    static {
        System.out.println("----a23");
        a22();
    }
}
class B extends A{
    public B(){
        System.out.println("----bb");
    }
    public void b12(){
        System.out.println("---b12");
        a12();
    }
    public static void b22(){
        System.out.println("----b22");
    }
    {
        System.out.println("----b13");
    }
    static {
        System.out.println("----b23");
        b22();
    }
}
class C{
    public static void main(String[] args) {
        B tt = new B();
        tt.b12();
    }
}
class Singleton{
    private static Singleton singleton = new Singleton();
    public static Singleton getInstance(){
        return singleton;
    }
}
class Singleton1{
    private static Singleton1 singleton1 = null;
    public static Singleton1 getSingleton1(){
        if(singleton1==null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

class Singleton3{
    private static volatile Singleton3 singleton3;
    private Singleton3(){

    }
    public static Singleton3 getSingleton3(){
        if(singleton3==null){
            synchronized (Singleton3.class){
                if(singleton3==null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}

