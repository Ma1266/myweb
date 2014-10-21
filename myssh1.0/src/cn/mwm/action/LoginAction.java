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
	* @Description: TODO(��¼����) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	* @date 2014-9-4 ����9:09:56 
	* @version V1.0
	 */
	public String goLoginPage() {
		return MAIN;
		
	}
	/**
	 * 
	* @Title: login 
	* @Description: TODO(�û���¼���) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	* @date 2014-8-28 ����11:16:31 
	* @version V1.0
	 */
	public void login() {
		Json j=new Json();
		
		User u=null;
		try {
			u = userService.getUserByName(user.getUsername());
			if(u==null){
				j.setMsg("���û��������ڣ���˲飡");
				j.setSuccess(false);
			}
			else if(u.getStatus()==-1){
				j.setMsg("���ʺ��Ѿ�������������ϵ����Ա��");
				j.setSuccess(false);
			}
			else if(!user.getPassword().equals(u.getPassword())){
				j.setMsg("�û�����Ӧ�������,��˲飡");
				j.setSuccess(false);
			}else{
				logger.info("�û�"+u.getUsername()+"��½�ɹ�����¼IP="+IpUtil.getIpAddr(this.getRequest()));
				j.setMsg("��½�ɹ�,������ת����ҳ,���Ժ�...");
				j.setSuccess(true);
				SessionInfo sessionInfo=new SessionInfo();
				String roles="";
				String orgName ="";

				Set<TUserRole> roleList=u.getTUserRoles();	
				logger.info("�û�"+u.getUsername()+"����"+roleList.size()+"��ϵͳ��ɫ!");
				if(roleList!=null && roleList.size()>0){
					for (TUserRole t : u.getTUserRoles()) {
						roles +=t.getTRole().getName()+",";
					}
					if(roles.length()>0){
						roles=roles.substring(0, roles.length()-1);
					}
				}else{
					j.setMsg("����û�з����κν�ɫȨ��,����ϵ����Ա��");
					j.setSuccess(false);
				}
			
				if(null!=u.getTOrganization()&& null != u.getTOrganization().getFullName()){
					orgName=u.getTOrganization().getFullName();
				}else{
					orgName="����������";
				}
				sessionInfo.setIp(IpUtil.getIpAddr(this.getRequest()));
				sessionInfo.setRoles(roles);
				sessionInfo.setOrgName(orgName);
				sessionInfo.setUserName(u.getUsername());
				sessionInfo.setUserId(u.getId());
				super.getSession().put("sessionInfo",sessionInfo);
			}
		} catch (Exception e) {
			j.setMsg("δ֪����"+e.getMessage()+"����ϵ����Ա��");
			j.setSuccess(false);
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	 * 
	* @Title: loginOff 
	* @Description: TODO(ע��) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	* @date 2014-9-4 ����9:15:20 
	* @version V1.0
	 */
    public String loginOff() {
    	Map<String, Object> sessionMap=getSession();
    	if(null != sessionMap){
    		sessionMap.clear();
    		logger.info(">>>�˳�ϵͳ��¼״̬,����û�session��Ϣ�ɹ�!");
    	}
		return MAIN;
		
	}
	@Override
	public User getModel() {
		return user;
	}
}
