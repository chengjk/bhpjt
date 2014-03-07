package com.supermap.bhpjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermap.bhpjt.dao.IDepartmentDao;
import com.supermap.bhpjt.po.Department;

@Service
public class DepartmentService {

	@Autowired
	private IDepartmentDao dao;
	
	/**
	 * 创建部门
	 * @param d
	 * @return
	 */
	public int add(Department d){
		return dao.save(d).getId();
	}
	/**
	 * 更新部门
	 * @param d
	 * @return
	 */
	public int update(Department d){
		return add(d);
	}
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	public boolean delete(int id){
		Department t= dao.findById(id);
		dao.delete(t);
		return true;
	}

	
}
