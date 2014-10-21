package cn.mwm.pageModel;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import cn.mwm.vo.Role;
import cn.mwm.vo.User;


public class SessionInfo  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3261715220897672211L;
	
	
	private String orgName;
	private String roles;
	private String userName;
	private String ip;
	private Integer userId;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	
}
