package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.test.entity.Person;
import cn.itcast.test.service.TestService;

public class TestMeger {
	
	ClassPathXmlApplicationContext context;

	@Before
	public void loadCtx() {
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	@Test
	public void testSpring() {
		TestService ts = (TestService)context.getBean("testService");
		ts.say();
	}
	
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("用户1"));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testReadOnlyTransaction() {
		//如果事务是配置正确的，在只读事务中不能进行写操作否则报错
		TestService ts = (TestService)context.getBean("testService");
		Person person = ts.findById("4028a033522536010152253604880000");
		System.out.println("人员名称为：" + person.getName());
	}
	
	@Test
	public void testRollbackTransaction() {
		//如果事务是配置正确的，当在方法中出现任何保存信息后将回滚前面所有的数据库操作
		TestService ts = (TestService)context.getBean("testService");
		ts.save(new Person("用户2"));
	}

}
