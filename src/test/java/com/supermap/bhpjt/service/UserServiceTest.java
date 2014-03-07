package com.supermap.bhpjt.service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.supermap.bhpjt.po.User;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("development")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserServiceTest {
	@Autowired
	private UserService ser;
	private User u=new User();
	
	@Before
	public void init() {
		u.setId(50);
		u.setUsername("test");
		u.setPassword("test");
		u.setEnable(1);
	}
	@Test
	public void checkUsername() {
		Assert.assertTrue("验证用户名",ser.checkUsername("usernull"));
	}
	
	@Test
	public void createUser(){
		int flag=ser.createUser(u);
		Assert.assertTrue("创建用户。",flag>0);
	}
	@Test
	public void validate(){
		Assert.assertNotNull("id=50;用户验证！",ser.validate(u));
	}
	@Test
	public void update() {
		u.setId(100);
		u.setUsername("updateTestUser");
		u.setAlias("更新测试");
		u.setEnable(1);
		Assert.assertTrue("更新用户。",ser.updateUser(u));
	}
	@Test
	public void deleteuser() {
		Assert.assertTrue("删除用户。",ser.deleteUser(50));
	}
	@Test
	public void findByDepartment() {
		Iterable<User> us=ser.getDepartmenUsers(0);
		Assert.assertTrue("查找顶级部门",us.iterator().hasNext());
	}
	
	@Test
	public void findBykeywords() {
		Iterable<User> us=ser.findByKeyword("es");
		Assert.assertTrue("关键字查找",us.iterator().hasNext());
	}
	
	

}
