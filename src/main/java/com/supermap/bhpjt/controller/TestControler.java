package com.supermap.bhpjt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TestControler {
	
	
	
	
	
	//----------error--------------
	@RequestMapping(value="hi",method=RequestMethod.GET)
	public int hi(){
		return 1;
	}
	@RequestMapping(value="bo",method=RequestMethod.GET)
	public boolean his(){
		return true;
	}

}
