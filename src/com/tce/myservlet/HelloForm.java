package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Terence 使用 URL 的 GET 方法实例 下面是一个简单的 URL，将使用 GET 方法向 HelloForm 程序传递两个值。
 *         http://localhost:8080/my_servlet/myservlet/HelloForm?first_name=ZARA&last_name=ALI
 *         下面是处理 Web 浏览器输入的 HelloForm.java Servlet 程序。 我们将使用 getParameter()
 *         方法，可以很容易地访问传递的信息：
 *
 */
//扩展 HttpServlet 类
public class HelloForm extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>名字</b>：" + request.getParameter("first_name") + "\n" + "  <li><b>姓氏</b>："
				+ request.getParameter("last_name") + "\n" + "</ul>\n" + "</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
