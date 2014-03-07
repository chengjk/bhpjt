package com.supermap.bhpjt.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.supermap.bhpjt.po.User;
public interface IUserDao extends PagingAndSortingRepository<User, Serializable> {

	@Query(value="from User where username=?1 and rownum=1")
	User existName(String name);
	User findById(int id);
	Iterable<User> findByDepartmentid(int dptid);
	@Query(value="from User where username=?1 and rownum=1")
	User findByUsername(String username);
	@Query(value="from User where username like ?1"
			+ " or alias like ?1")
	Iterable<User> findByKeyword(String key);

	
}
