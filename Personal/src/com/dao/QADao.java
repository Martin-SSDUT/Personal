package com.dao;

import java.util.List;

import com.entity.QA;

public interface QADao {
		public boolean login(String name,String pwd);//��¼
		public List<QA> getQAAll();//������������
		public List<QA> getQASearch(String sqlString);//������������
}
