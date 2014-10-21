package cn.mwm.pageModel;

import cn.mwm.model.TFunction;
import cn.mwm.model.TUser;

public class CurrentUser {

	private TUser tuser;
	private String ip;
	private TFunction func;
	public TUser getTuser() {
		return tuser;
	}
	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public TFunction getFunc() {
		return func;
	}
	public void setFunc(TFunction func) {
		this.func = func;
	}
	
}
