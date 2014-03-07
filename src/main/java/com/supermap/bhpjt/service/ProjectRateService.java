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
	 * �½���Ŀ
	 * @param p
	 * @return
	 */
	public int createPoject(ProjectRate p){
		return dao.save(p).getId();
	}
	/**
	 * ������Ŀ
	 * @param p
	 * @return
	 */
	public int update(ProjectRate p){
		return dao.save(p).getId();
	}
	
	/**
	 * ���Ҹ���ʱ�����������Ŀ
	 * @param d
	 * @return
	 */
	public Iterable<ProjectRate> findByProjectid(int pid){
		return dao.findByProjectId(pid);
	}
	
	
	
	
}
