package cn.itcast.test.dao;

import java.io.Serializable;

import cn.itcast.test.entity.Person;

public interface TestDao {
	 
	//保存用户
	public void save(Person person);
	//根据用户ID查询用户
	public Person findById(Serializable id);

}
