package cn.project.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.project.core.util.Constant;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 判断当前的请求是否是登录请求
		String uri = request.getRequestURI();
		if (!uri.contains("/sys/login_")) {// 非登录请求，需要验证session中是否存在用户信息
			if (request.getSession().getAttribute(Constant.USER) != null) {
				// 说明已经登录
				chain.doFilter(request, response);
			} else {
				// 没有登录返回登录页面
				response.sendRedirect(request.getContextPath() + "/sys/login_toLoginUI.action");
			}
		} else {
			// 登录请求直接放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
