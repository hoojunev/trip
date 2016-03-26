package cn.itcast.core.permission;

import cn.itcast.nsfw.user.entity.User;

public interface PermissionCheck {

	/**
	 * 判断user用户中是否包含有code对应的权限
	 * @param user 用户
	 * @param code 权限标识符
	 * @return true or false
	 */
	public boolean isAccessible(User user, String code);
	
	public boolean permissionCheck(User user);
}
