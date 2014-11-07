package cn.mvc.common.interceptor;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* @ClassName: SessionTimeoutInterceptor 
* @Description: TODO(����session��ʱʱ������) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-11-6 ����10:25:31 
*
 */
public class SessionTimeoutInterceptor implements HandlerInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SessionTimeoutInterceptor.class);

	/**
	 * ������DispatcherServlet��ȫ����������󱻵��� 
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

		logger.info("������SessionTimeoutInterceptor.afterCompletion()����");
	}

	/**
	 * ������ҵ��������������֮�󱻵��� 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		logger.info("������SessionTimeoutInterceptor.postHandle()����");
	}

	/**
	 * ������ҵ��������������(controllor)֮ǰִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		logger.info("������SessionTimeoutInterceptor.preHandle()����");
		//�˴�������session�ж���,�������session��������,���������������ָ���Ľ���
		return true;
	}

}
