package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.entity.Admin;
import com.entity.QA;
import com.util.DBconn;

import com.util.DBconn;


public class AdminDaoImpl implements AdminDao{
		public boolean login(String name,String pwd) {
			boolean isAdmin = false;
			try {
				DBconn.init();
				ResultSet rs = DBconn.selectSql("select password from admin where name = '" + name + "' limit 1");
				if(rs.next()) {
					if(pwd.equals(rs.getString(1)))
					{
						isAdmin = true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return isAdmin;
		}
		public boolean register(String name,String pwd) {
			boolean isSuccessed = false;
			try {
				DBconn.init();
				String insertSql = "insert into admin values (null,'" + name + "','" + pwd + "')";
				System.out.println(insertSql);
				DBconn.insertSql(insertSql);
				ResultSet rs = DBconn.selectSql("select * from admin where name = '" + name + "'");
				if(rs.next())
					isSuccessed = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return isSuccessed;
		}
		public boolean isExist(String name,String pwd) {
			boolean isExist = false;
			try {
				DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from admin where name = '" + name + "'");
				if(rs.next()) {
					isExist = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return isExist;
		}
}
