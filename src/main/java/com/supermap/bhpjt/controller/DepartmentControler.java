package com.supermap.bhpjt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermap.bhpjt.po.Department;
import com.supermap.bhpjt.service.DepartmentService;

@Controller
@RequestMapping(value="department")
public class DepartmentControler {
	@Autowired
	private DepartmentService ser;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public @ResponseBody int add(Department d){
		return ser.add(d);
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public int update(Department d){
		return ser.update(d);
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public boolean add(int id){
		return ser.delete(id);
	}
	
	
	

}
