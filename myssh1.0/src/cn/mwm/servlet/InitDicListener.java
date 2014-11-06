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




/**系统启动时加载数据字典
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
			//加载数据字典
			logger.info("*****系统启动,开始加载数据字典******");
			ApplicationContext act=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
			IDictionaryService dicD=(IDictionaryService)act.getBean("dicService");
			//List<TDictionary> dic=dicD.findAllDic();
			//将数据字典放入系统缓存中 待完成
			logger.info("*****系统启动成功,数据字典加载完成******");
		} catch (BeansException e) {
			e.printStackTrace();
			logger.info("数据字典加载出错"+e.getMessage());

		} 	
		
	}
       
	

}
