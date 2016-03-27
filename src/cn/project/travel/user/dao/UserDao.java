package cn.project.travel.user.dao;

import java.io.Serializable;
import java.util.List;

import cn.project.core.dao.BaseDao;
import cn.project.travel.user.entity.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 用户帐号唯一性校验：根据帐号和ID查询用户列表；如果存在列表说明该帐号已经存在不可使用，如果不存在用户列表说明可使用该帐号
	 * 
	 * @param account 用户帐号
	 * @param id 用户ID（在编辑时排除该ID对应的用户）
	 * @return 用户列表
	 */
	public List<User> findUsersByAccountAndId(String account, String id);

	/**
	 * 根据用户ID删除该用户的所有用户角色
	 * 
	 * @param id 用户ID
	 */
	public void deleteUserRolesByUserId(Serializable id);

	/**
	 * 根据用户ID获取用户对应的所有用户角色
	 * 
	 * @param id 用户ID
	 * @return 用户角色列表
	 */
	public List<User> findUsersByAccountAndPass(String account, String password);

}
