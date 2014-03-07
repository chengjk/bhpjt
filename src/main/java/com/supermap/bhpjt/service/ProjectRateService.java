package com.supermap.bhpjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermap.bhpjt.dao.IProjectRateDao;
import com.supermap.bhpjt.po.ProjectRate;

@Service
public class ProjectRateService {

	@Autowired
	private IProjectRateDao dao;
	/**
	 * 新建项目
	 * @param p
	 * @return
	 */
	public int createPoject(ProjectRate p){
		return dao.save(p).getId();
	}
	/**
	 * 更新项目
	 * @param p
	 * @return
	 */
	public int update(ProjectRate p){
		return dao.save(p).getId();
	}
	
	/**
	 * 查找给定时间点后的所有项目
	 * @param d
	 * @return
	 */
	public Iterable<ProjectRate> findByProjectid(int pid){
		return dao.findByProjectId(pid);
	}
	
	
	
	
}
