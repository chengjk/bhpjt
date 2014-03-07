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
	 * �½���Ŀ
	 * @param p
	 * @return
	 */
	public int createPoject(Project p){
		return dao.save(p).getId();
	}
	/**
	 * ������Ŀ
	 * @param p
	 * @return
	 */
	public int update(Project p){
		return dao.save(p).getId();
	}
	
	
	/**
	 * ���Ҹ���ʱ�����������Ŀ
	 * @param d
	 * @return
	 */
	public Iterable<Project> findNews(Date d){
		return dao.findNewsByUpdateTime(d);
	}
	
	
	
	
}
