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
 * 	    网站点击计数器:
 *         很多时候，您可能有兴趣知道整个网站的总点击量。在 Servlet 中，这也是非常简单的，我们可以使用过滤器做到这一点。
 *         以下是实现一个简单的基于过滤器生命周期的网站点击计数器需要采取的步骤： 在过滤器的 init() 方法中初始化一个全局变量。 
 *         每次调用doFilter 方法时，都增加全局变量。 如果需要，您可以使用一个数据库表来存储全局变量的值在过滤器的 destroy()
 *         中。在下次初始化过滤器时，该值可在 init() 方法内被读取。这一步是可选的。 在这里，我们假设 Web
 *         容器将无法重新启动。如果是重新启动或 Servlet 被销毁，点击计数器将被重置。
 */
public class SiteHitCounter implements Filter {
	private int hitCount;
	
	public void init(FilterConfig config) throws ServletException{
		hitCount=0;
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) 
			throws IOException,ServletException{
		hitCount++;
		System.out.println("网站访问统计: "+hitCount);
		chain.doFilter(request, response);		// 放行，通过了当前过滤器，递交给下一个filter进行过滤	
		// 在doFilter（）方法中，chain.doFilter()前的一般是对request执行的过滤操作，chain.doFilter后面的代码一般是对response执行的操作。
		// web.xml中监听器配置在过滤器之前，过滤器配置在servlet之前，否则会出错。
	}
	public void destroy() {
		
	}
}
