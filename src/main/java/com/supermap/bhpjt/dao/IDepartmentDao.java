package com.supermap.bhpjt.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.supermap.bhpjt.po.Department;
public interface IDepartmentDao extends PagingAndSortingRepository<Department, Serializable> {

	Department findById(int id);

	

	

	
}
