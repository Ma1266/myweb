package cn.mwm.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TOrganization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_organization", catalog = "mysshe")
public class TOrganization implements java.io.Serializable {

	// Fields

	private Integer organizationId;
	private Integer assistantManager;
	private Integer companyId;
	private Timestamp created;
	private Integer creater;
	private String description;
	private Integer empQty;
	private String ename;
	private String fax;
	private String fullName;
	private String iconcls;
	private Timestamp lastmod;
	private Integer manager;
	private Integer modifyer;
	private String myid;
	private Integer pid;
	private String shortName;
	private String state;
	private String status;
	private String tel;
	private Set<TUser> TUsers = new HashSet<TUser>(0);

	// Constructors

	/** default constructor */
	public TOrganization() {
	}

	/** minimal constructor */
	public TOrganization(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/** full constructor */
	public TOrganization(Integer organizationId, Integer assistantManager,
			Integer companyId, Timestamp created, Integer creater,
			String description, Integer empQty, String ename, String fax,
			String fullName, String iconcls, Timestamp lastmod,
			Integer manager, Integer modifyer, String myid, Integer pid,
			String shortName, String state, String status, String tel,
			Set<TUser> TUsers) {
		this.organizationId = organizationId;
		this.assistantManager = assistantManager;
		this.companyId = companyId;
		this.created = created;
		this.creater = creater;
		this.description = description;
		this.empQty = empQty;
		this.ename = ename;
		this.fax = fax;
		this.fullName = fullName;
		this.iconcls = iconcls;
		this.lastmod = lastmod;
		this.manager = manager;
		this.modifyer = modifyer;
		this.myid = myid;
		this.pid = pid;
		this.shortName = shortName;
		this.state = state;
		this.status = status;
		this.tel = tel;
		this.TUsers = TUsers;
	}

	// Property accessors
	@Id
	@Column(name = "ORGANIZATION_ID", unique = true, nullable = false)
	@GeneratedValue
	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	@Column(name = "ASSISTANT_MANAGER")
	public Integer getAssistantManager() {
		return this.assistantManager;
	}

	public void setAssistantManager(Integer assistantManager) {
		this.assistantManager = assistantManager;
	}

	@Column(name = "COMPANY_ID")
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "CREATED", length = 19)
	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Column(name = "CREATER")
	public Integer getCreater() {
		return this.creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "EMP_QTY")
	public Integer getEmpQty() {
		return this.empQty;
	}

	public void setEmpQty(Integer empQty) {
		this.empQty = empQty;
	}

	@Column(name = "ENAME", length = 100)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "FAX", length = 50)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "FULL_NAME")
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "ICONCLS", length = 100)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "LASTMOD", length = 19)
	public Timestamp getLastmod() {
		return this.lastmod;
	}

	public void setLastmod(Timestamp lastmod) {
		this.lastmod = lastmod;
	}

	@Column(name = "MANAGER")
	public Integer getManager() {
		return this.manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	@Column(name = "MODIFYER")
	public Integer getModifyer() {
		return this.modifyer;
	}

	public void setModifyer(Integer modifyer) {
		this.modifyer = modifyer;
	}

	@Column(name = "MYID", length = 25)
	public String getMyid() {
		return this.myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	@Column(name = "PID")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "SHORT_NAME", length = 50)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "STATE", length = 20)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "TEL", length = 50)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganization")
	public Set<TUser> getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set<TUser> TUsers) {
		this.TUsers = TUsers;
	}

}