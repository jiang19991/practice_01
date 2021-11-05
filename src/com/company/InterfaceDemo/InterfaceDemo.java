package com.company.InterfaceDemo;

import com.company.InterfaceDemo.Dao.DaoFactory;
import com.company.InterfaceDemo.Dao.Impl.UserDaoJDBCImpl;
import com.company.InterfaceDemo.Dao.UserDao;
import com.company.InterfaceDemo.Util.ArrayUtil;
import com.company.InterfaceDemo.Util.Comparator;

import java.util.Arrays;

public class InterfaceDemo implements Constant {
    public static void main(String[] args) {
        System.out.println(WIDTH + "*" + HEIGHT);
//        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.SelectCountUser();

        //工厂模式的使用
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        System.out.println(userDao.SelectCountUser());

       int[] array = {5, 1, 4, 3, 6};//扑克牌比大小，A（1）最大
        //命令模式的使用
        ArrayUtil.sort(array, new ComparatorImpl());
        System.out.println(Arrays.toString(array));
    }
}

class ComparatorImpl implements Comparator {
    //重写了比较器，定义1最大
    @Override
    public int compare(int m, int n) {
        if (m == n)
            return 0;
        else if (m == 1)
            return 1;
        else if (n == 1)
            return -1;
        else return m > n ? 1 : -1;
    }
}
