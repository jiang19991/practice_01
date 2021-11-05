package com.company.InterfaceDemo.Dao;

import com.company.InterfaceDemo.Dao.Impl.UserDaoJDBCImpl;

//工厂模式
public class DaoFactory {
    public UserDao getUserDao(){
        return new UserDaoJDBCImpl();
    }
}
