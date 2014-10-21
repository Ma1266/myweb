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
		logger.info("����Actionk��ʼ����session������,���������·��Ϊ:"+ServletActionContext.getRequest().getRequestURI());
		//ActionContext cxt = invocation.getInvocationContext();
		//Map<String, Object> map = cxt.getSession();
		SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(GlobleNames.SESSION_INFO);
		if (null == sessionInfo){
			String errMsg = "����û�е�¼���¼�ѳ�ʱ�������µ�¼��Ȼ����ˢ�±����ܣ�";
			System.out.println(errMsg);
			//ServletActionContext.getRequest().setAttribute("msg", errMsg);
			return GlobleNames.NO_SESSION;
		}
		logger.info("��ȡSession�ɹ�,��������ҳ��---");
		return invocation.invoke();
	}

}
