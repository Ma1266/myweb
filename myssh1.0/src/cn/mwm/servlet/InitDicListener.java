package cn.mwm.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.mwm.exception.BusinessException;
import cn.mwm.model.TDictionary;
import cn.mwm.service.IDictionaryService;
import cn.mwm.service.IUserService;




/**ϵͳ����ʱ���������ֵ�
 * Servlet implementation class InitDicListener
 */
public class InitDicListener implements ServletContextListener{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InitDicListener.class);

	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	    try {
			//���������ֵ�
			logger.info("*****ϵͳ����,��ʼ���������ֵ�******");
			ApplicationContext act=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
			IDictionaryService dicD=(IDictionaryService)act.getBean("dicService");
			//List<TDictionary> dic=dicD.findAllDic();
			//�������ֵ����ϵͳ������ �����
			logger.info("*****ϵͳ�����ɹ�,�����ֵ�������******");
		} catch (BeansException e) {
			e.printStackTrace();
			logger.info("�����ֵ���س���"+e.getMessage());

		} 	
		
	}
       
	

}
