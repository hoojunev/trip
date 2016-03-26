package cn.itcast.test.service;

import java.io.Serializable;

import cn.itcast.test.entity.Person;

public interface TestService {

	// 输出一句话
	public void say();

	// 保存用户
	public void save(Person person);

	// 根据用户ID查询用户
	public Person findById(Serializable id);
}
