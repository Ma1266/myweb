package junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.mwm.exception.BusinessException;
import cn.mwm.model.TDictionary;
import cn.mwm.model.TUser;
import cn.mwm.service.IDictionaryService;
import cn.mwm.service.IUserService;
import cn.mwm.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../spring.xml","../spring-hibernate.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=false,transactionManager="transactionManager")
public class UserServiceTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void test_getUserByName()  {
		User tuser;
		try {
			tuser = userService.getUserByName("admin");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
