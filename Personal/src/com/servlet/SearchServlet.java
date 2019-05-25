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

import net.sf.json.JSONArray;

public class SearchServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			String searchInfo = request.getParameter("searchInfo");//得到jsp页面传过来的参数
			String questionType = request.getParameter("questionType");
			String searchRange = request.getParameter("searchRange");
			System.out.println("searchInfo   " + searchInfo);
			System.out.println("questionType   " + questionType);
			System.out.println("searchRange   " + searchRange);
			String sqlString = "select * from zibo_anjian_question_bank";
			if (!questionType.equals("不限")) {
				sqlString += " where type = \"" + questionType + "\"";
				if (searchRange.equals("按题干")) {
					sqlString += " and question like \"%" + searchInfo + "%\"";
				}else if(searchRange.equals("按答案")) {
					sqlString += " and answer like \"%" + searchInfo + "%\"";
				}else if(searchRange.equals("不限")) {
					sqlString += " and question like \"%" + searchInfo + "%\"" + " or answer like \"%" + searchInfo + "%\"";
				}
			}
			else{
				if (searchRange.equals("按题干")) {
					sqlString += " where question like \"%" + searchInfo + "%\"";
				}else if(searchRange.equals("按答案")) {
					sqlString += " where answer like \"%" + searchInfo + "%\"";
				}else if(searchRange.equals("不限")) {
					sqlString += " where question like \"%" + searchInfo + "%\"" + " or answer like \"%" + searchInfo + "%\"";
				}
			}
			QADao qad = new QADaoImpl();
			System.out.println(sqlString);
			List<QA> QAAll = qad.getQASearch(sqlString);
			System.out.println(QAAll);
//			request.setAttribute("QAAll", QAAll);   
//			request.getRequestDispatcher("searchInfo.jsp").forward(request,response);//转发到成功页面
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("loginName");
			String pwd = (String)session.getAttribute("password");
			if(qad.login(name, pwd)) {
				response.getWriter().write(JSONArray.fromObject(QAAll).toString()); 
			}else {
				String loseInfo = "['lose']";
				response.getWriter().write(JSONArray.fromObject(loseInfo).toString()); 
			}
		}
}
