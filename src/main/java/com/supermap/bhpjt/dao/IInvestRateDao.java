package com.supermap.bhpjt.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.supermap.bhpjt.po.InvestRate;
public interface IInvestRateDao extends PagingAndSortingRepository<InvestRate, Serializable> {


	@Query(value="from InvestRate where projectId =?1 "
			+ "and rownum=1 "
			+ "order by updateTime")
	InvestRate getLatestRateForProject(int id);
	
}
