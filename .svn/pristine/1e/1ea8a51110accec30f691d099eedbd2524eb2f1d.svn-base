package cn.itcast.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.itcast.test.dao.TestDao;
import cn.itcast.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findById(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
