package com.tce.myservlet;

//�������� java ��

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// ��չ HttpServlet ��
public class CheckBox extends HttpServlet {

	/**
	 * @author Terence
	 * ����ѡ�����ݴ��ݵ� Servlet ����
	 */

	// ���� GET ��������ķ���
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������Ӧ��������
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String title = "��ȡ��ѡ������";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>��ѧ��ʶ��</b>: " + request.getParameter("maths") + "\n" + "  <li><b>�����ʶ��</b>: "
				+ request.getParameter("physics") + "\n" + "  <li><b>��ѧ��ʶ��</b>: " + request.getParameter("chemistry")
				+ "\n" + "</ul>\n" + "</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}
}
