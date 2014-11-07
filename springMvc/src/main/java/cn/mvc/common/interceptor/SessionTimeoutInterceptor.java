package cn.mvc.common.interceptor;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* @ClassName: SessionTimeoutInterceptor 
* @Description: TODO(设置session超时时拦截器) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-11-6 上午10:25:31 
*
 */
public class SessionTimeoutInterceptor implements HandlerInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SessionTimeoutInterceptor.class);

	/**
	 * 方法在DispatcherServlet完全处理完请求后被调用 
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

		logger.info("调用了SessionTimeoutInterceptor.afterCompletion()方法");
	}

	/**
	 * 方法在业务处理器处理请求之后被调用 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		logger.info("调用了SessionTimeoutInterceptor.postHandle()方法");
	}

	/**
	 * 方法在业务处理器处理请求(controllor)之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		logger.info("调用了SessionTimeoutInterceptor.preHandle()方法");
		//此处可以做session判断了,如果存在session则处理请求,如果不存在则跳到指定的界面
		return true;
	}

}
