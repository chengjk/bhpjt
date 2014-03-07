package com.supermap.bhpjt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.supermap.bhpjt.po.ProjectFull;
import com.supermap.bhpjt.service.ProjectFullService;

@Controller
@RequestMapping(value="/project")
public class ProjectFullController {

	@Autowired
	private ProjectFullService ser;
	@RequestMapping(value="create",method=RequestMethod.POST)
	public int createProject(ProjectFull p) {
		return ser.createPoject(p);
	}

	@RequestMapping(value="findNews",method=RequestMethod.POST)
	public Iterable<ProjectFull> getNews(Date d) {
		return ser.findNews(d);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public int updateProject(ProjectFull p) {
		return ser.update(p);
	}

	
	
	//////////////////////////
	//---not implement
	//////////////////////
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public int delete(int id) {
		return -1;
	}

	
	
}
