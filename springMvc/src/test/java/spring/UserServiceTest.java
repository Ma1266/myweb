package spring;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.mvc.model.SysUser;
import cn.mvc.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
//@TransactionConfiguration(defaultRollback=false,transactionManager="transactionManager")
public class UserServiceTest {

	
	@Autowired
	private UserService userService;
	
	
	
	@Test
	public void findById() throws Exception {
		
		SysUser user=new SysUser();
		//user.setId("1");
		
		user=userService.findByLoginName("admin");
		System.out.println(user.getName());
	}
}
