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
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class LoginServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			//得到前端页面传过来的参数
			String name = request.getParameter("loginName");
			String pwd = request.getParameter("pwd");
			
			AdminDao admin = new AdminDaoImpl();
			if(admin.login(name, pwd)) {
				//向request域中放置信息(键值对的形式)
//				request.setAttribute("loginName",name);
//				request.setAttribute("password", pwd);
				//初次登录，设置session
				HttpSession session = request.getSession();
				session.setAttribute("loginName", name);
				session.setAttribute("password", pwd);
				/*
				 * 设置session有效期
				 * 该方式为java代码设置，优先级最高，单位为秒；
				 * 也可以通过配置xml的方式设置，单位为分钟
				 */
				request.getSession().setMaxInactiveInterval(300);
				request.getRequestDispatcher("success.jsp").forward(request,response);//转发到成功页面
			}else {
				request.setAttribute("loseInfo", "用户名或密码错误，登录失败！");
				request.getRequestDispatcher("lose.jsp").forward(request,response);//转发到失败页面
			}
		}
}
