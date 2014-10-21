package cn.mwm.action;

import org.apache.log4j.Logger;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.mwm.pageModel.SessionInfo;
import cn.mwm.service.IMenuService;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MenuAction extends BaseAction{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4637298519264434150L;



	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MenuAction.class);

	
	
	@Autowired
	private IMenuService menuService;
	public void getAllMenu(){
		//SessionInfo sessionInfo=(SessionInfo) super.getSession().get("sessionInfo");
		//logger.info("根据用户查询+"+super.getCurrentUser().getTuser().getUsername());
		super.writeJson(menuService.getAllMenu(super.getCurrentUser().getUserId()));
	}

}
