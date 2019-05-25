package com.util;

import java.sql.*;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/rlm_ssdut?serverTimezone=GMT&useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	static String username = "root";
	static String password = "";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	public static ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch(SQLException e) {
			System.out.println("sql数据库查询异常");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.out.println("sql数据库关闭异常");
		}
	}
}
