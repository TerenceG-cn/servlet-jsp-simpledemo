package com.tce.myservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloFormWithCookie extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		Cookie firstName=new Cookie("first_name",request.getParameter("first_name"));
		Cookie lastName=new Cookie("last_name",request.getParameter("last_name"));
		 // 为两个 Cookies 设置过期日期为 24 小时后
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		//在响应头中添加两个 Cookies
		response.addCookie(firstName);
		response.addCookie(lastName);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
	      String title = "设置 Cookies 实例";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>名字</b>："
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>姓氏</b>："
	                + request.getParameter("last_name") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}
}
