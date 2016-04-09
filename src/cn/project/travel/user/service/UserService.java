package cn.project.travel.user.service;

import java.util.List;

import cn.project.core.service.BaseService;
import cn.project.travel.user.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * 根据用户ID获取用户对应的所有用户角色
	 * 
	 * @param id 用户ID
	 * @return 用户角色列表
	 */
	public List<User> findUsersByAccountAndPass(String account, String password, String role);
}
