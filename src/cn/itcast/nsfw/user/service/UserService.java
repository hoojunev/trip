package cn.itcast.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.itcast.core.exception.ServiceException;
import cn.itcast.core.service.BaseService;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;

public interface UserService extends BaseService<User> {

	/**
	 * 导出用户列表到Excel
	 * @param userList 用户列表
	 * @param outputStream 输出流
	 */
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);
	/**
	 * 导入用户列表数据到数据库中
	 * @param userExcel 用户列表Excel文件
	 */
	public void importExcel(File userExcel);
	/**
	 * 用户帐号唯一性校验：根据帐号和ID查询用户列表；如果存在列表说明该帐号已经存在不可使用，如果不存在用户列表说明可使用该帐号
	 * @param account 用户帐号
	 * @param id 用户ID（在编辑时排除该ID对应的用户）
	 * @return 用户列表
	 */
	public List<User> findUsersByAccountAndId(String account, String id);
	
	/**
	 * 保存用户及用户对应的角色
	 * @param user 用户信息
	 * @param roleIds 角色ID数组
	 */
	public void saveUserAndRole(User user, String... roleIds);
	
	/**
	 * 更新用户及用户对应的角色
	 * @param user 用户信息
	 * @param roleIds 角色ID数组
	 */
	public void updateUserAndRole(User user, String... roleIds);
	/**
	 * 根据用户ID获取用户对应的所有用户角色
	 * @param id 用户ID
	 * @return 用户角色列表
	 */
	public List<UserRole> getUserRolesByUserId(String id);
	/**
	 * 根据帐号和密码查询用户列表
	 * @param account 用户帐号
	 * @param password 密码
	 * @return 用户列表
	 */
	public List<User> findUsersByAccountAndPass(String account, String password);
}
