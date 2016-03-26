package cn.itcast.core.permission.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.core.permission.PermissionCheck;
import cn.itcast.core.util.Constant;
import cn.itcast.nsfw.role.entity.Role;
import cn.itcast.nsfw.role.entity.RolePrivilege;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;
import cn.itcast.nsfw.user.service.UserService;

public class PermissionCheckImpl implements PermissionCheck {
	
	@Resource
	private UserService userService;

	@Override
	public boolean isAccessible(User user, String code) {
		//判断user中使用对应有code对应的权限
		List<UserRole> userRoles = user.getUserRoles();
		
		if(userRoles == null){
			userRoles = userService.getUserRolesByUserId(user.getId());
		}
		
		for(UserRole ur: userRoles){//遍历该用户的所有角色
			Role role = ur.getId().getRole();
			for(RolePrivilege rp: role.getRolePrivileges()){
				if(code.equals(rp.getId().getCode())){
					//说明存在权限返回true
					return true;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean permissionCheck(User user){
		for (String userName : Constant.ITEM_PERMISSION_LIST) {
			if(userName.equals(user.getAccount())){
				return true;
			}
		}
		return false;
	}
}
