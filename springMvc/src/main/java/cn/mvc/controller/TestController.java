package cn.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mvc.model.User;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

	
	
	
	@RequestMapping("/getUser")
	@ResponseBody
	public  User getUser(User u) throws Exception{
		u.setUserName("ADMIN");
		u.setPassword("123456");
		/*if(u==null){
			throw new SQLException("Êý¾Ý¿âÒì³£");
		}*/
		return u;		
	}
	
	
	
	
/*	@RequestMapping("/test1")
	@ResponseBody
	public User test1(@RequestBody User u){
		return u;		
	}
	@RequestMapping("/test2")
	@ResponseBody
	public User test2(User u){
		return u;		
	}
	@RequestMapping("/test3")
	@ResponseBody
	public User test3(@RequestParam User u){
		return u;		
	}
	@RequestMapping("/test4")
	@ResponseBody
	public Date test4(Date date){
		return date;		
	}*/
}
