package com.supermap.bhpjt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermap.bhpjt.dao.IProjectDao;
import com.supermap.bhpjt.po.Project;

@Service
public class ProjectService {

	@Autowired
	private IProjectDao dao;
	/**
	 * 新建项目
	 * @param p
	 * @return
	 */
	public int createPoject(Project p){
		return dao.save(p).getId();
	}
	/**
	 * 更新项目
	 * @param p
	 * @return
	 */
	public int update(Project p){
		return dao.save(p).getId();
	}
	
	
	/**
	 * 查找给定时间点后的所有项目
	 * @param d
	 * @return
	 */
	public Iterable<Project> findNews(Date d){
		return dao.findNewsByUpdateTime(d);
	}
	
	
	
	
}
