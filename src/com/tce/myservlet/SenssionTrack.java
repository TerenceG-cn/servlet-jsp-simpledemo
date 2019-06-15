package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Terence 本实例说明了如何使用 HttpSession 对象获取 session 会话创建时间和最后访问时间。 如果不存在
 *         session 会话，我们将通过请求创建一个新的 session 会话。
 */
public class SenssionTrack extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		HttpSession session = request.getSession(true);
		Date createTime = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		String title = "欢迎回到我的网站";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("ABCD");

		if (session.isNew()) {
			title = "欢迎来到网站";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount = visitCount + 1;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);

		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<h2 align=\"center\">Session 信息</h2>\n" + "<table border=\"1\" align=\"center\">\n"
				+ "<tr bgcolor=\"#949494\">\n" + "  <th>Session 信息</th><th>值</th></tr>\n" + "<tr>\n" + "  <td>id</td>\n"
				+ "  <td>" + session.getId() + "</td></tr>\n" + "<tr>\n" + "  <td>Creation Time</td>\n" + "  <td>"
				+ createTime + "  </td></tr>\n" + "<tr>\n" + "  <td>Time of Last Access</td>\n" + "  <td>"
				+ lastAccessTime + "  </td></tr>\n" + "<tr>\n" + "  <td>User ID</td>\n" + "  <td>" + userID
				+ "  </td></tr>\n" + "<tr>\n" + "  <td>Number of visits</td>\n" + "  <td>" + visitCount + "</td></tr>\n"
				+ "</table>\n" + "</body></html>");
	}

}
