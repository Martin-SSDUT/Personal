package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.QADao;
import com.dao.QADaoImpl;
import com.entity.QA;

import com.entity.Admin;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class WholeInfoServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			//获取session信息
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("loginName");
			String pwd = (String)session.getAttribute("password");
			//响应的相关设置
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			AdminDao admin = new AdminDaoImpl();
			if(admin.login(name, pwd)) {
				QADao qad = new QADaoImpl();
				List<QA> QAAll = qad.getQAAll();
				request.setAttribute("QAAll", QAAll);
				request.getRequestDispatcher("wholeInfo.jsp").forward(request,response);//转发到全部信息页面
			}else {
				request.setAttribute("loseInfo", "请保持登录状态查询此页面！");
				request.getRequestDispatcher("lose.jsp").forward(request,response);//转发到失败页面
			}
		}
}
