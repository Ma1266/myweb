package cn.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mvc.model.User;
import cn.mvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/deleteByIds")
	public int deleteByIds(String ids) throws Exception{
		return userService.deleteByIds(ids);
		
	}
	
	@RequestMapping("/getJson")
	public @ResponseBody User getJson(){
		User u=new User();
		u.setPassword("122");
		u.setUserName("name");
		
		return u;
	}
	
	@RequestMapping("/getXml")
	public @ResponseBody User getXml() {
		User u=new User();
		u.setPassword("122");
		u.setUserName("name");
		return u;
	}
}
