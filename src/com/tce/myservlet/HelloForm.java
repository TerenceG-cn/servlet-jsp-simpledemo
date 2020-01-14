package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Terence ʹ�� URL �� GET ����ʵ�� ������һ���򵥵� URL����ʹ�� GET ������ HelloForm ���򴫵�����ֵ��
 *         http://localhost:8080/my_servlet/myservlet/HelloForm?first_name=ZARA&last_name=ALI
 *         �����Ǵ��� Web ���������� HelloForm.java Servlet ���� ���ǽ�ʹ�� getParameter()
 *         ���������Ժ����׵ط��ʴ��ݵ���Ϣ��
 *
 */
//��չ HttpServlet ��
public class HelloForm extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������Ӧ��������
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String title = "ʹ�� GET ������ȡ������";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>����</b>��" + request.getParameter("first_name") + "\n" + "  <li><b>����</b>��"
				+ request.getParameter("last_name") + "\n" + "</ul>\n" + "</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
