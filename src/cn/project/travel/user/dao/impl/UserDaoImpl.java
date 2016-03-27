package cn.project.travel.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import cn.project.core.dao.impl.BaseDaoImpl;
import cn.project.travel.user.dao.UserDao;
import cn.project.travel.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> findUsersByAccountAndId(String account, String id) {
		String hql = "FROM User WHERE account=?";
		if (StringUtils.isNotBlank(id)) {
			hql += " AND id !=?";
		}
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter(0, account);
		if (StringUtils.isNotBlank(id)) {
			query.setParameter(1, id);
		}
		return query.list();
	}

	@Override
	public void deleteUserRolesByUserId(Serializable id) {
		getCurrentSession().createQuery("DELETE FROM UserRole WHERE id.userId=?").setParameter(0, id).executeUpdate();
	}

	@Override
	public List<User> findUsersByAccountAndPass(String account, String password) {
		Query query = getCurrentSession().createQuery("FROM User WHERE account=? AND password=? AND state=?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		query.setParameter(2, User.USER_STATE_VALID);
		return query.list();
	}

}
