package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.entity.Admin;
import com.entity.QA;
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
}
