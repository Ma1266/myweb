package cn.mwm.interceptor;

import org.apache.log4j.Logger;


import org.apache.struts2.ServletActionContext;
import cn.mwm.constant.GlobleNames;
import cn.mwm.pageModel.SessionInfo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SessionInterceptor extends MethodFilterInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		logger.info("请求Actionk开始进入session拦截器,本次请求的路径为:"+ServletActionContext.getRequest().getRequestURI());
		//ActionContext cxt = invocation.getInvocationContext();
		//Map<String, Object> map = cxt.getSession();
		SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(GlobleNames.SESSION_INFO);
		if (null == sessionInfo){
			String errMsg = "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！";
			System.out.println(errMsg);
			//ServletActionContext.getRequest().setAttribute("msg", errMsg);
			return GlobleNames.NO_SESSION;
		}
		logger.info("获取Session成功,进入请求页面---");
		return invocation.invoke();
	}

}
