package spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mvc.controller.UserController;
import cn.mvc.service.UserService;

public class Test2 {

	@Autowired
	private UserService userService;
	
	private UserController userController;
	@Test
	public  void test1() throws Exception {
		ApplicationContext act=new ClassPathXmlApplicationContext("classpath:applicationContext.xml","classpath:springmvc-servlet.xml");
		UserService userService2=(UserService) act.getBean("userService");	
		UserController userController2=(UserController) act.getBean("userController");	
		try {
			//userService2.findByLoginName("");
			System.out.println(userController2.deleteByIds("1,2,3"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
