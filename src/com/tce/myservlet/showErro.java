package com.tce.myservlet;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
public class showErro extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		response.sendError(407,"Need authentication!!!");
	}
}
