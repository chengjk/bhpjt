package com.supermap.bhpjt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.supermap.bhpjt.po.Project;
import com.supermap.bhpjt.service.ProjectService;

@Controller
@RequestMapping(value="/simple")
public class ProjectController {

	@Autowired
	private ProjectService ser;
	@RequestMapping(value="create",method=RequestMethod.POST)
	public int createProject(Project p) {
		return ser.createPoject(p);
	}

	@RequestMapping(value="update",method=RequestMethod.POST)
	public int updateProject(Project p) {
		return ser.update(p);
	}

	@RequestMapping(value="delete",method=RequestMethod.POST)
	public int delete(int id) {
		return -1;
	}

	@RequestMapping(value="findNews",method=RequestMethod.POST)
	public Iterable<Project> getNews(Date d) {
		return ser.findNews(d);
	}

	
	
}
