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

public class WholeInfoServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
			
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("loginName");
			String pwd = (String)session.getAttribute("password");
			QADao qad = new QADaoImpl();
			if(qad.login(name, pwd)) {
				List<QA> QAAll = qad.getQAAll();
				request.setAttribute("QAAll", QAAll);
				request.getRequestDispatcher("wholeInfo.jsp").forward(request,response);//ת�����ɹ�ҳ��
			}else {
				request.setAttribute("loseInfo", "�뱣�ֵ�¼״̬��ѯ��ҳ�棡");
				request.getRequestDispatcher("lose.jsp").forward(request,response);//ת�����ɹ�ҳ��
			}
		}
}