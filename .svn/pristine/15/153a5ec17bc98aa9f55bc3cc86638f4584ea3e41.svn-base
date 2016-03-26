package cn.itcast.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.core.permission.PermissionCheck;
import cn.itcast.core.util.Constant;
import cn.itcast.nsfw.user.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		//判断当前的请求是否是登录请求
		String uri = request.getRequestURI();
		if(!uri.contains("/sys/login_")){//非登录请求，需要验证session中是否存在用户信息
			if(request.getSession().getAttribute(Constant.USER) != null){
				//说明已经登录
				//判断当前系统是否有 纳税服务 系统的权限
				if(uri.contains("/nsfw/")){
					//访问纳税服务子系统
					//获取随着应用服务器启动时加载并实例的ioc容器
					WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					PermissionCheck pc = (PermissionCheck)context.getBean("permissionCheck");
					
					User user = (User) request.getSession().getAttribute(Constant.USER);
					if(pc.isAccessible(user, "nsfw")){
						
						if(uri.contains("/nsfw/reserveItem_")){
							
							if(pc.permissionCheck(user)){
								chain.doFilter(request, response);
							}else{
								response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
							}
							
						}else{
							chain.doFilter(request, response);
						}
					} else {
						//说明没有权限跳转到没有权限提示页面
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				} else {
					//不访问纳税服务子系统则直接放行
					chain.doFilter(request, response);
				}
			} else {
				//没有登录返回登录页面
				response.sendRedirect(request.getContextPath()+"/sys/login_toLoginUI.action");
			}
		} else {
			//登录请求直接放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
