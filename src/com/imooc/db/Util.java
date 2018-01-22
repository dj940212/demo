package com.imooc.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Util {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER="root";
    private static final String PASSWORD="";

    private static Connection conn=null;

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库有链接
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
