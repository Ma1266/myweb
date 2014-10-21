package cn.mwm.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
@Action(value="passWordAction")
public class PassWordAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PassWordAction.class);

	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassWord() {		
		logger.info("ÃÜÂëÐÞ¸Ä³É¹¦");
		return userName;	
	}
}
