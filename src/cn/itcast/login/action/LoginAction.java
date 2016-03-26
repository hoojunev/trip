package cn.itcast.login.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.itcast.core.util.Constant;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private User user;
	private String loginResult;
	
	@Resource
	private UserService userService;

	//跳转到登录页面
	public String toLoginUI(){
		return "loginUI";
	}
	
	//登录
	public String login(){
		if(user != null){
			//1、获取帐号和密码
			if(StringUtils.isNotBlank(user.getAccount()) && StringUtils.isNotBlank(user.getPassword())){
				//2、根据帐号和密码查询用户列表
				List<User> userList = userService.findUsersByAccountAndPass(user.getAccount(), user.getPassword());
				//2.1、登录成功
				if(userList != null && userList.size() > 0){
					//2.1.1、获取用户信息
					user = userList.get(0);
					//2.1.2、根据用户ID查询该用户的所有用户角色
					user.setUserRoles(userService.getUserRolesByUserId(user.getId()));
					//2.1.3、将用户信息存入session
					ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, user);
					//2.1.4、将用户登录信息记录到日志文件
					Log log = LogFactory.getLog(getClass());
					log.info("用户名为：" + user.getName() + " 的用于登录系统");
					//2.1.5、跳转到系统首页（重定向）
					return "home";
				} else {
					//登录失败，跳转到登录页面
					loginResult = "登录失败。帐号或密码错误！";
				}
			} else {
				loginResult = "帐号或密码不能为空！";
			}
		} else {
			loginResult = "帐号和密码不能为空！";
		}
		return toLoginUI();
	}
	
	//退出
	public String logout(){
		//清空session中用户信息
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.USER);
		return toLoginUI();
	}
	
	//跳转到没有权限提示页面
	public String toNoPermissionUI(){
		return "noPermissionUI";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	
}
