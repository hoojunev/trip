package cn.project.travel.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.project.core.service.impl.BaseServiceImpl;
import cn.project.travel.user.dao.UserDao;
import cn.project.travel.user.entity.User;
import cn.project.travel.user.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> findUsersByAccountAndPass(String account, String password, String role) {
		return userDao.findUsersByAccountAndPass(account, password, role);
	}

}
