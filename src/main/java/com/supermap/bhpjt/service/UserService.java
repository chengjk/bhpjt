package com.supermap.bhpjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermap.bhpjt.dao.IUserDao;
import com.supermap.bhpjt.po.User;
import com.supermap.bhpjt.util.HqlHelper;
import com.supermap.bhpjt.util.MD5Tool;

@Service
public class UserService {

	@Autowired
	private IUserDao dao;
	
	/**
	 * 验证用户名的合法性
	 * @param name
	 * @return
	 */
	public boolean checkUsername(String name) {
		return dao.existName(name)==null;
	}
	
	
	
	/**
	 * 创建用户
	 * @param u
	 * @return
	 */
	public int createUser(User u){
		u.setPassword(MD5Tool.encode(u.getPassword()));
		u.setEnable(1);
		return dao.save(u).getId();
	}

	
	/**
	 * 更新用户
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u){
		User db=null;
		String pw=u.getPassword();
		if(pw==null||pw.equals("")){
			db=dao.findById(u.getId());
			u.setPassword(db.getPassword());
		}else{
			u.setPassword(MD5Tool.encode(u.getPassword()));
		}
		
		return dao.save(u)!=null;
	}
	/**
	 * 删除用户
	 * @param u
	 * @return
	 */
	public boolean deleteUser(int id){
		User t= dao.findById(id);
		t.setEnable(0);
		return dao.save(t)!=null;
	}
	
	
	/**
	 * 用户验证
	 * @param u
	 * @return
	 */
	public User validate(User u){
		User db=dao.findByUsername(u.getUsername());
		
		boolean flag= db.getPassword().equalsIgnoreCase(MD5Tool.encode(u.getPassword()));
		if(flag){
			return db;
		}
		return null;
	}
	
	/**
	 * 查找部门下全部用户
	 * @param dptid
	 * @return
	 */
	public Iterable<User> getDepartmenUsers(int dptid) {
		return dao.findByDepartmentid(dptid);
	}
	/**
	 * 关键字查询
	 * @param key
	 * @return
	 */
	public Iterable<User> findByKeyword(String key) {
		return dao.findByKeyword(HqlHelper.strToLike(key));
	}
	
	
	
	
}
