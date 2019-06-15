package com.tce.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseAccess extends HttpServlet {
	// JDBC
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";//加时区

	static final String user = "root";
	static final String pass = "guo19980611";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String title = "数据库结果";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n");

		try {
			// import java.sql.Connection;
			// import java.sql.DriverManager
			// import java.sql.Statement;
			Class.forName("com.mysql.cj.jdbc.Driver");//以前为com.mysql.jdbc.Driver,现在的url要加时区
			Connection conn = DriverManager.getConnection(DB_URL, user, pass);
			Statement stmt = conn.createStatement();
			String sql = "select id,first,last,age from employees";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");

				// 输出数据
				out.println("ID: " + id);
				
				out.println(", Age: " + age);
				out.println(", First: " + first);
				out.println(", Last: " + last + "<br>");
			}
			out.println("</body></html>");

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} 
	}
}
