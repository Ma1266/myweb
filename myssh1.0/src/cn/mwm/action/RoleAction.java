package cn.mwm.action;

import java.util.List;

import javax.swing.text.html.ListView;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;


import cn.mwm.exception.BusinessException;
import cn.mwm.model.TRole;
import cn.mwm.pageModel.Json;
import cn.mwm.service.IRoleService;
import cn.mwm.vo.Role;

import com.opensymphony.xwork2.ModelDriven;

@Action("roleAction")
public class RoleAction extends BaseAction implements ModelDriven<TRole>{

	
	 
	private TRole role=new TRole();
	private IRoleService roleService;
	
	public IRoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public void getAllRoleList(){
		Json j =new Json();
		try {
			List<TRole> roleList=roleService.getAllRoleList();
			j.setMsg("查询成功");
			j.setSuccess(true);
			this.writeJson(roleList);
		} catch (BusinessException e) {
			e.printStackTrace();
			j.setMsg("查询失败:"+e.getMessage());
			j.setSuccess(false);
		}
	}
	
	@Override
	public TRole getModel() {
		// TODO Auto-generated method stub
		return role;
	}

}
