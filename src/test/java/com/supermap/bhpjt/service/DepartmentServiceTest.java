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

import com.supermap.bhpjt.po.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("development")
@TransactionConfiguration(defaultRollback = false)  
@Transactional
public class DepartmentServiceTest {
	@Autowired
	private DepartmentService ser;
	private Department d=new Department();
	@Before
	public void init() {
		d.setNameFull("nameFull");
		d.setNameBrief("nameBrief");
		d.setLeader("leader");
		d.setTelephone("telephone");
		d.setParentId(0);
		d.setRemarker("remarker");
	}
	@Test
	public void add(){
		int flag=ser.add(d);
		d.setId(flag);
		Assert.assertTrue("创建部门。",flag>0);
	}
	@Test
	public void update() {
		d.setRemarker("remarkerupdate");
		Assert.assertTrue("更新部门。",ser.update(d)>0);
	}
	@Test
	public void deleteuser() {
		Assert.assertTrue("删除部门。",ser.delete(4350));
	}
	

}
