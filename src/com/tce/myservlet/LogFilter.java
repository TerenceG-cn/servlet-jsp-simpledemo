package com.tce.myservlet;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
//Servlet ��������ʵ����������ͻ��˵� IP ��ַ�͵�ǰ������ʱ�䡣

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
//ipv6:0:0:0:0:0:0:0:1��ipv4:127.0.0.1 ,localhost

/**
 * ��������Ӧ��˳�� web.xml �е� filter-mapping Ԫ�ص�˳������� Web ����Ӧ�ù������� Servlet ��˳��
 * ��req���ı�ʱ��filiter��web�е����ú�˳��û�й�ϵ��
 * ������filiter�н���ı�����ʱ���ᵼ����ı��request���Ͱ�װ��ι��࣬�޷���ȡ���еĲ���
 * ��Ҫ��ת��������˳����ֻ��Ҫ�� web.xml �ļ��з�ת filter-mapping Ԫ�ؼ��ɡ� 
 * <filter>
 * 		<filter-name>LogFilter</filter-name>
 * 		<filter-class>com.tce.myservlet.LogFilter</filter-class> 
 * 		<init-param>
 * 			<param-name>Site</param-name> 
 * 			<param-value>w3cschool���߽̳�</param-value>
 * 		</init-param> 
 * </filter> 
 * <filter-mapping> 
 * 		<filter-name>LogFilter</filter-name>
 * 		<url-pattern>/*</url-pattern> 
 * </filter-mapping>
 */
