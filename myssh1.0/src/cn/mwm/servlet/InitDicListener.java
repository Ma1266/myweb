package cn.mwm.servlet;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.mwm.dao.IndicDao;
import cn.mwm.model.TDictionary;
import cn.mwm.service.IDictionaryService;
import cn.mwm.service.IUserService;

/**
 * Servlet implementation class InitDicListener
 */
public class InitDicListener extends HttpServlet implements ServletContextListener {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InitDicListener.class);

	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitDicListener() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sct) {
    	//加载数据字典
    	logger.info("*****系统启动,开始加载数据字典******");
    	try {
			ApplicationContext act=WebApplicationContextUtils.getWebApplicationContext(sct.getServletContext());
			// IDictionaryService dicD=(IDictionaryService)act.getBean("dicService");
			 //List<TDictionary> dic=dicD.findAllDic();
			//IUserService userService=(IUserService) act.getBean("userService");
			//userService.getUserByName("admi100");
			logger.info("*****系统启动成功,数据字典加载完成******");
		} catch (BeansException e) {
			logger.info("数据字典加载出错"+e.getMessage());
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
