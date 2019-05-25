package com.dao;

import java.util.List;

import com.entity.QA;

public interface QADao {
		public boolean login(String name,String pwd);//登录
		public List<QA> getQAAll();//返回所有问题
		public List<QA> getQASearch(String sqlString);//返回所有问题
}
