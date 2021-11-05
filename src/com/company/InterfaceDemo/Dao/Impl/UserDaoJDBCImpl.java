package com.company.InterfaceDemo.Dao.Impl;

import com.company.InterfaceDemo.Dao.UserDao;

public class UserDaoJDBCImpl implements UserDao {
    @Override
    public int SelectCountUser() {
        System.out.println("通过JDBC查询了用户数量");
        return 100;
    }
}
