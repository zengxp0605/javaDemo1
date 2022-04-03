package com.stan.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter 初始化");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		System.out.println("拦截 URI="+request.getRequestURI());
		chain.doFilter(req, res);
	}

	// 关闭服务时会调用
	@Override
	public void destroy() {
		System.out.println("Filter 结束");
	}
}
