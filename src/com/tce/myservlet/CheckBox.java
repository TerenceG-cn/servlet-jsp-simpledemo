package com.tce.myservlet;

//导入必需的 java 库

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class CheckBox extends HttpServlet {

	/**
	 * @author Terence
	 * 将复选框数据传递到 Servlet 程序
	 */

	// 处理 GET 方法请求的方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String title = "读取复选框数据";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>数学标识：</b>: " + request.getParameter("maths") + "\n" + "  <li><b>物理标识：</b>: "
				+ request.getParameter("physics") + "\n" + "  <li><b>化学标识：</b>: " + request.getParameter("chemistry")
				+ "\n" + "</ul>\n" + "</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}
}
