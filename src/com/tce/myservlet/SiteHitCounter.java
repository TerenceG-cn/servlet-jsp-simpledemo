package com.tce.myservlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//
/**
 * @author Terence 
 * 	    ��վ���������:
 *         �ܶ�ʱ������������Ȥ֪��������վ���ܵ�������� Servlet �У���Ҳ�Ƿǳ��򵥵ģ����ǿ���ʹ�ù�����������һ�㡣
 *         ������ʵ��һ���򵥵Ļ��ڹ������������ڵ���վ�����������Ҫ��ȡ�Ĳ��裺 �ڹ������� init() �����г�ʼ��һ��ȫ�ֱ����� 
 *         ÿ�ε���doFilter ����ʱ��������ȫ�ֱ����� �����Ҫ��������ʹ��һ�����ݿ�����洢ȫ�ֱ�����ֵ�ڹ������� destroy()
 *         �С����´γ�ʼ��������ʱ����ֵ���� init() �����ڱ���ȡ����һ���ǿ�ѡ�ġ� ��������Ǽ��� Web
 *         �������޷�������������������������� Servlet �����٣�����������������á�
 */
public class SiteHitCounter implements Filter {
	private int hitCount;
	
	public void init(FilterConfig config) throws ServletException{
		hitCount=0;
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) 
			throws IOException,ServletException{
		hitCount++;
		System.out.println("��վ����ͳ��: "+hitCount);
		chain.doFilter(request, response);		// ���У�ͨ���˵�ǰ���������ݽ�����һ��filter���й���	
		// ��doFilter���������У�chain.doFilter()ǰ��һ���Ƕ�requestִ�еĹ��˲�����chain.doFilter����Ĵ���һ���Ƕ�responseִ�еĲ�����
		// web.xml�м����������ڹ�����֮ǰ��������������servlet֮ǰ����������
	}
	public void destroy() {
		
	}
}
