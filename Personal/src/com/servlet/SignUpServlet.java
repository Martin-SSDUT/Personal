package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;

import net.sf.json.JSONArray;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class SignUpServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			//得到前端页面传过来的参数
			String name = request.getParameter("signUpName");
			String pwd = request.getParameter("password");
			System.out.println("name " + name);
			System.out.println("pwd " + pwd);
			//响应的相关设置
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			AdminDao admin = new AdminDaoImpl();
			if(!admin.isExist(name, pwd)) {
				if(admin.register(name, pwd)) {
					System.out.println("注册成功！");
					String info = "['success']";
					response.getWriter().write(JSONArray.fromObject(info).toString()); 
				}
			}else {
				String info = "['lose']";
				response.getWriter().write(JSONArray.fromObject(info).toString()); 
			}
		}
}
