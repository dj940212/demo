package com.imooc.dao;

import com.imooc.db.Util;
import com.imooc.model.Goddess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class GoddessDao {
    private void addGoddess(Goddess g) throws Exception{
        Connection conn= Util.getConnection();
        String sql=""+
        "insert into imooc_goddess" +
        "(user_name,sex,age,birthday,email,mobile," +
        "create_user,create_date,update_user,update_date,isdel)" +
        "values(" +
        "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setString(1, g.getUser_name());
//        ptmt.setInt(2, g.getSex());
//        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getCreate_user());
        ptmt.setString(8, g.getUpdate_user());
//        ptmt.setInt(9, g.getIsdel());
        ptmt.execute();
    }
}
