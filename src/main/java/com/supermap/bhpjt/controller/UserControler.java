package com.supermap.bhpjt.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.supermap.bhpjt.po.User;
import com.supermap.bhpjt.service.UserService;

@Controller
public class UserControler {
	@Autowired
	private UserService ser;
	
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping(value="usereditor",method=RequestMethod.GET)
	public ModelAndView editor(){
		ModelAndView mv=new ModelAndView("usereditor");
		return mv;
	}
	
	@RequestMapping(value="user/validate",method=RequestMethod.GET)
	private @ResponseBody User validate(String username,String password){
		User u=new User();
		u.setUsername(username);
		u.setPassword(password);
		return ser.validate(u);
	}

	
	@RequestMapping(value="user/add",method=RequestMethod.POST)
	private @ResponseBody int add(User u) throws UnsupportedEncodingException {
		String alias=u.getAlias();
		String re= URLDecoder.decode(alias,"utf-8");
		u.setAlias(re);
		return ser.createUser(u);
	}
	
	
	@RequestMapping(value="user/checkusername",method=RequestMethod.GET)
	private @ResponseBody boolean checkusername(String username) {
		return ser.checkUsername(username);
	}
	
	
	@RequestMapping(value="user/update",method=RequestMethod.GET)
	private @ResponseBody boolean update(User u) {
		return ser.updateUser(u);
	}
	
	
	@RequestMapping(value="user/delete",method=RequestMethod.GET)
	private @ResponseBody boolean delete(int id) {
		return ser.deleteUser(id);
	}
	
	@RequestMapping(value="user/department",method=RequestMethod.GET)
	private @ResponseBody Iterable<User> departmen(int dptid) {
		return ser.getDepartmenUsers(dptid);
	}

	//¹Ø¼ü×Ö²éÑ¯
	@RequestMapping(value="user/findkeyword/json",method=RequestMethod.GET)
	private @ResponseBody Iterable<User> keywordjson(String key) {
		return ser.findByKeyword(key);
	}
	@RequestMapping(value="user/findkeyword/page",method=RequestMethod.GET)
	private ModelAndView keywordpage(String key) {
		ModelAndView mv=new ModelAndView("usertable");
		mv.addObject("data",ser.findByKeyword(key));
		return mv;
	}
	
	
	

}
