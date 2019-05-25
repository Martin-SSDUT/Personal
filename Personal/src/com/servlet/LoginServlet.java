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

public class LoginServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			String name = request.getParameter("loginName");//�õ�jspҳ�洫�����Ĳ���
			String pwd = request.getParameter("pwd");
			
			QADao qa = new QADaoImpl();
			if(qa.login(name, pwd)) {
//				request.setAttribute("loginName",name);//��request���з�����Ϣ(��ֵ�Ե���ʽ)
//				request.setAttribute("password", pwd);
				HttpSession session = request.getSession();
				session.setAttribute("loginName", name);
				session.setAttribute("password", pwd);
				/*
				 * ����session��Ч��
				 * �÷�ʽΪjava�������ã����ȼ���ߣ���λΪ�룻
				 * Ҳ����ͨ������xml�ķ�ʽ���ã���λΪ����
				 */
				request.getSession().setMaxInactiveInterval(300);
				request.getRequestDispatcher("success.jsp").forward(request,response);//ת�����ɹ�ҳ��
			}else {
				request.setAttribute("loseInfo", "�û�����������󣬵�¼ʧ�ܣ�");
				request.getRequestDispatcher("lose.jsp").forward(request,response);//ת�����ɹ�ҳ��
			}
		}
}
