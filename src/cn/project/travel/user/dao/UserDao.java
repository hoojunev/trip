package cn.project.travel.user.dao;

import java.util.List;

import cn.project.core.dao.BaseDao;
import cn.project.travel.user.entity.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 根据用户ID获取用户对应的所有用户角色
	 * 
	 * @param id 用户ID
	 * @return 用户角色列表
	 */
	public List<User> findUsersByAccountAndPass(String account, String password, String role);

}
