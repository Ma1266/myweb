package junit;

import org.junit.Test;

import cn.mwm.exception.BusinessException;

public class ExceptionTest {

	
	
	@Test
	public void test1() throws BusinessException  {
		int [] arr={1,3,4};
		int a=arr[5];
	}
}
