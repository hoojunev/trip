package cn.project.travel.user.dao.impl;

import java.util.List;

import org.hibernate.Query;

import cn.project.core.dao.impl.BaseDaoImpl;
import cn.project.travel.user.dao.UserDao;
import cn.project.travel.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> findUsersByAccountAndPass(String account, String password, String role) {
		Query query = getCurrentSession().createQuery(
			"FROM User WHERE account=? AND password=? AND state=? AND role= ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		query.setParameter(2, User.USER_STATE_VALID);
		query.setParameter(3, role);
		return query.list();
	}

}
