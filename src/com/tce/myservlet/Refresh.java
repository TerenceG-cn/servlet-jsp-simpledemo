package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;

public class Refresh extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// ����ˢ���Զ�����ʱ��Ϊ5s
		response.setIntHeader("Refresh", 5);
		/**
		 * ��1������ˢ��ʱ��Refresh
		 * response.setIntHeader("Refresh", 1);//��λ����
		 * response.setHeader("Refresh", "2;URL=/day08_00_response/login.html");//��λ����
		 * ��2���ļ�����
		 *resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
		 *resp.setHeader("Content-Type", "application/octet-stream");
		 *��3�� ���û���ʱ��Expires
		 *ȡֵ��һ������ֵ�������ֵС�ڵ�ǰʱ�䣬�򲻻��档
		 *response.setDateHeader("Expires", System.currentTimeMillis()+1*60*60*1000)
		 *��4�������ض���Location
		 *��һ�ַ�����
		 *response.setStatus(302);
		 *response.setHeader("Location", "/day08_00_response/login.html");
		 *�ڶ��ַ�����
		 *response.sendRedirect("/day08_00_response/login.html");
		 */

		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";

		String currentTime = hour + ":" + min + ":" + sec + " " + am_pm;

		PrintWriter out = response.getWriter();
		String title = "�Զ�ˢ�� Header ����";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" + "<p>��ǰʱ���ǣ�" + currentTime + "</p>\n");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
