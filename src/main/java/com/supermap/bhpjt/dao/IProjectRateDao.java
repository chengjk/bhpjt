package com.supermap.bhpjt.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.supermap.bhpjt.po.ProjectRate;
public interface IProjectRateDao extends PagingAndSortingRepository<ProjectRate, Serializable> {
	Iterable<ProjectRate> findByProjectId(int id);
	
	@Query(value="from ProjectRate where projectId =?1 "
			+ "and rownum=1 "
			+ "order by updateTime")
	ProjectRate getLatestRateForProject(int id);
}
