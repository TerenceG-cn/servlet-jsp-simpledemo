package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentDate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String title = "显示当前的日期和时间";
		// 获取当前的日期和时间
		Date date = new Date();
//		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
//		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
//				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<h2 align=\"center\">"
//				+ date.toString() + "</h2>\n" + "</body></html>");
		// 使用 SimpleDateFormat 格式化日期
		Date dateN = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a 'luckyTime' zzz");
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" + "<h2 align=\"center\">" + date.toString()
						+ "</h2>\n" + "<h2 align=\"center\">" + ft.format(dateN) + "</h2>\n" + "</body></html>");
	}
}
