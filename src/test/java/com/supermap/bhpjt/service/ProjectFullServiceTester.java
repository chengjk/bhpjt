package com.supermap.bhpjt.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.supermap.bhpjt.po.ProjectFull;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("development")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class ProjectFullServiceTester {
	@Autowired
	private ProjectFullService ser;
	ProjectFull pf=new ProjectFull();
	
	@Before
	public void init(){
		pf.setGeneral("general");	
	}
	@Test
	public void create(){
		ProjectFull pf=new ProjectFull();
		pf.setGeneral("general");
		Assert.assertTrue("创建全项目。",ser.createPoject(pf)>0);
	}
	@Test
	public void findnews() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dt=sdf.parse("2000-01-01 01:01:01");
		Assert.assertTrue("查找更新", ser.findNews(dt).iterator().hasNext());
	}
	@Test
	public void update(){
		pf.setId(1);
		pf.setName("updateTest");
		Assert.assertTrue("更新全项目！", 1==ser.update(pf));
	}

}
