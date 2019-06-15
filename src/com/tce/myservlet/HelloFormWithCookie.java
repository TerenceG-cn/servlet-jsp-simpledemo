package com.tce.myservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloFormWithCookie extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Cookie firstName=new Cookie("first_name",request.getParameter("first_name"));
		Cookie lastName=new Cookie("last_name",request.getParameter("last_name"));
		 // Ϊ���� Cookies ���ù�������Ϊ 24 Сʱ��
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		//����Ӧͷ��������� Cookies
		response.addCookie(firstName);
		response.addCookie(lastName);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
	      String title = "���� Cookies ʵ��";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>����</b>��"
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>����</b>��"
	                + request.getParameter("last_name") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}
}
