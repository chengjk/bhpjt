package com.supermap.bhpjt.dao;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.supermap.bhpjt.po.Project;
public interface IProjectDao extends PagingAndSortingRepository<Project, Serializable> {

	@Query(value="from Project  where updateTime > ?1")
	public Iterable<Project> findNewsByUpdateTime(Date d);
}
