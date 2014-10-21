package cn.mwm.action;


import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.mwm.constant.GlobleNames;
import cn.mwm.model.TRole;
import cn.mwm.model.TUserRole;
import cn.mwm.pageModel.Json;
import cn.mwm.pageModel.SessionInfo;
import cn.mwm.service.IUserService;
import cn.mwm.utils.IpUtil;
import cn.mwm.vo.Role;
import cn.mwm.vo.User;

import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends BaseAction implements ModelDriven<User> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	
	@Autowired
	private IUserService userService;
	private User user=new User();
	
	
	/**
	 * 
	* @Title: goLoginPage 
	* @Description: TODO(登录界面) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @date 2014-9-4 下午9:09:56 
	* @version V1.0
	 */
	public String goLoginPage() {
		return MAIN;
		
	}
	/**
	 * 
	* @Title: login 
	* @Description: TODO(用户登录入口) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	* @date 2014-8-28 上午11:16:31 
	* @version V1.0
	 */
	public void login() {
		Json j=new Json();
		
		User u=null;
		try {
			u = userService.getUserByName(user.getUsername());
			if(u==null){
				j.setMsg("该用户名不存在！请核查！");
				j.setSuccess(false);
			}
			else if(u.getStatus()==-1){
				j.setMsg("该帐号已经被锁定！请联系管理员！");
				j.setSuccess(false);
			}
			else if(!user.getPassword().equals(u.getPassword())){
				j.setMsg("用户名对应密码错误,请核查！");
				j.setSuccess(false);
			}else{
				logger.info("用户"+u.getUsername()+"登陆成功！登录IP="+IpUtil.getIpAddr(this.getRequest()));
				j.setMsg("登陆成功,正在跳转至主页,请稍候...");
				j.setSuccess(true);
				SessionInfo sessionInfo=new SessionInfo();
				String roles="";
				String orgName ="";

				Set<TUserRole> roleList=u.getTUserRoles();	
				logger.info("用户"+u.getUsername()+"共有"+roleList.size()+"个系统角色!");
				if(roleList!=null && roleList.size()>0){
					for (TUserRole t : u.getTUserRoles()) {
						roles +=t.getTRole().getName()+",";
					}
					if(roles.length()>0){
						roles=roles.substring(0, roles.length()-1);
					}
				}else{
					j.setMsg("您还没有分配任何角色权限,请联系管理员！");
					j.setSuccess(false);
				}
			
				if(null!=u.getTOrganization()&& null != u.getTOrganization().getFullName()){
					orgName=u.getTOrganization().getFullName();
				}else{
					orgName="无隶属部门";
				}
				sessionInfo.setIp(IpUtil.getIpAddr(this.getRequest()));
				sessionInfo.setRoles(roles);
				sessionInfo.setOrgName(orgName);
				sessionInfo.setUserName(u.getUsername());
				sessionInfo.setUserId(u.getId());
				super.getSession().put("sessionInfo",sessionInfo);
			}
		} catch (Exception e) {
			j.setMsg("未知错误："+e.getMessage()+"请联系管理员！");
			j.setSuccess(false);
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	 * 
	* @Title: loginOff 
	* @Description: TODO(注销) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @date 2014-9-4 下午9:15:20 
	* @version V1.0
	 */
    public String loginOff() {
    	Map<String, Object> sessionMap=getSession();
    	if(null != sessionMap){
    		sessionMap.clear();
    		logger.info(">>>退出系统登录状态,清除用户session信息成功!");
    	}
		return MAIN;
		
	}
	@Override
	public User getModel() {
		return user;
	}
}
