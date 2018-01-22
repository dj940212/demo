package com.imooc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    private static final String URL="jdbc:mysql://59.110.164.55:3306/imooc";
    private static final String USER="root";
    private static final String PASSWORD="root";

    public  static void main(String[] args) throws Exception{
        //1.加载驱动程序
       Class.forName("com.mysql.jdbc.Driver");
       //2.获取数据库链接
        DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT user_name,age FROM imooc_goddess");

        while (rs.next()) {
            System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
        }
    }
}
