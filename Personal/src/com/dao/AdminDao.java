package com.dao;

import java.util.List;

import com.entity.Admin;

public interface AdminDao {
	public boolean login(String name,String pwd);//登录
	public boolean register(String name,String pwd);//注册
	public boolean isExist(String name,String pwd);//数据库中是否存在
}

