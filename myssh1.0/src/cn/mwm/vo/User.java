package cn.mwm.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.mwm.model.TOrganization;
import cn.mwm.model.TRole;
import cn.mwm.model.TUserRole;
import cn.mwm.utils.ExcelVOAttribute;

public class User {

	//@ExcelVOAttribute(name="���",isExport=true,column="A",prompt="�û���Ϣ")
	private Integer id;
	//@ExcelVOAttribute(name="�û���",column="B")
	private String username;
	private String password;	
	//@ExcelVOAttribute(name="�ǳ�",column="C")
	private String nickname;
	//@ExcelVOAttribute(name="����",column="D")
	private String email;
	//@ExcelVOAttribute(name="�绰����",column="E")
	private String phone;
	//@ExcelVOAttribute(name="״̬",column="F")
	private Integer status;
	//@ExcelVOAttribute(name="����ʱ��",column="G")
	private Timestamp createDate;
	//@ExcelVOAttribute(name="ͼƬ",column="H")
	private String image;	
	private String sort;
	//@ExcelVOAttribute(name="��ע",column="I")
	private String direction;
	
	//ҵ��չ�ֶ�  ���������ݿ�
	private TOrganization TOrganization;
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);
	public TOrganization getTOrganization() {
		return TOrganization;
	}

	public void setTOrganization(TOrganization tOrganization) {
		TOrganization = tOrganization;
	}

	public Set<TUserRole> getTUserRoles() {
		return TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> tUserRoles) {
		TUserRoles = tUserRoles;
	}

	//@ExcelVOAttribute(name="��ɫ",column="J")
	private  String roleNameList;
	private Integer roleId;
	//@ExcelVOAttribute(name="����",column="K")
	private  String orgName;
	private  Integer orgId;
	private  Date beginTime;
	private  Date endTime;
	
	private String ids;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getRoleNameList() {
		return roleNameList;
	}

	public void setRoleNameList(String roleNameList) {
		this.roleNameList = roleNameList;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	

	
}
