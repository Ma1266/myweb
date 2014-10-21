package junit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mwm.service.IUserService;


public class SpringTest {

	//@Autowired
	//private IUserService userService;
	@Test
	public void getname() {
		ApplicationContext act=new ClassPathXmlApplicationContext("classpath*:../spring.xml,classpath*:../spring-hibernate.xml");
		IUserService userService=(IUserService) act.getBean("userService");
		//userService.getUserByName("a");
		System.out.println();
	}
}
