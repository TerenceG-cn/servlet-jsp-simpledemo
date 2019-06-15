package com.tce.myservlet;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
//Servlet 过滤器的实例，将输出客户端的 IP 地址和当前的日期时间。

public class LogFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
		String testParam = config.getInitParameter("test-param");

		System.out.println("Test Param: " + testParam);

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		System.out.println("IP: " + ipAddress + ", Time" + new Date().toString());
		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}

//IP: 0:0:0:0:0:0:0:1, TimeMon Mar 25 18:22:24 CST 2019
//ipv6:0:0:0:0:0:0:0:1，ipv4:127.0.0.1 ,localhost

/**
 * 过滤器的应用顺序 web.xml 中的 filter-mapping 元素的顺序决定了 Web 容器应用过滤器到 Servlet 的顺序。
 * 当req不改变时，filiter在web中的配置和顺序没有关系；
 * 但当在filiter中将其改变类型时，会导致其改变的request类型包装层次过多，无法获取其中的参数
 * 若要反转过滤器的顺序，您只需要在 web.xml 文件中反转 filter-mapping 元素即可。 
 * <filter>
 * 		<filter-name>LogFilter</filter-name>
 * 		<filter-class>com.tce.myservlet.LogFilter</filter-class> 
 * 		<init-param>
 * 			<param-name>Site</param-name> 
 * 			<param-value>w3cschool在线教程</param-value>
 * 		</init-param> 
 * </filter> 
 * <filter-mapping> 
 * 		<filter-name>LogFilter</filter-name>
 * 		<url-pattern>/*</url-pattern> 
 * </filter-mapping>
 */
