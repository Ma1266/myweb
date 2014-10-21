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
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô) 
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
		//logger.info("�����û���ѯ+"+super.getCurrentUser().getTuser().getUsername());
		super.writeJson(menuService.getAllMenu(super.getCurrentUser().getUserId()));
	}

}
