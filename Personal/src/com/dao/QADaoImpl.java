package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.entity.QA;
import com.util.DBconn;

public class QADaoImpl implements QADao{
		public List<QA> getQAAll(){
			List<QA> list = new ArrayList<QA>();
			try {
				DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from zibo_anjian_question_bank");
				while(rs.next()) {
					QA qa = new QA();
					qa.setId(rs.getInt("id"));
					qa.setQuestion(rs.getString("question"));
					qa.setAnswer(rs.getString("answer"));
					qa.setType(rs.getString("type"));
					list.add(qa);
				}
				DBconn.closeConn();
				return list;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		public List<QA> getQASearch(String sqlString){
			List<QA> list = new ArrayList<QA>();
			try {
				DBconn.init();
				ResultSet rs = DBconn.selectSql(sqlString);
				while(rs.next()) {
					QA qa = new QA();
					qa.setId(rs.getInt("id"));
					qa.setQuestion(rs.getString("question"));
					qa.setAnswer(rs.getString("answer"));
					qa.setType(rs.getString("type"));
					list.add(qa);
				}
				DBconn.closeConn();
				return list;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
