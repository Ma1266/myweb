package junit;

import org.junit.Test;

import cn.mwm.exception.BusinessException;
import cn.mwm.vo.User;

public class ExceptionTest {

	
	
	@Test
	public void test1() throws BusinessException  {
		
	}
	
	public static void main(String[] args) throws BusinessException {
		try {
			//int [] arr={1,3,4};
			//int a=arr[5];
			User user=null;
			user.getUsername();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			throw new BusinessException("ϵͳ������ָ�����:"+e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("δ֪����"+e.getMessage());
		}
	}
}
