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
 * TFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_function", catalog = "mysshe")
public class TFunction implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer pid;
	private String url;
	private Integer sort;
	private String iconCls;
	private Integer status;
	private String description;
	private Timestamp createdate;
	private Timestamp updatedatetime;
	private Integer creater;
	private Integer modifyer;
	private Integer type;
	private Set<TRoleFunc> TRoleFuncs = new HashSet<TRoleFunc>(0);

	// Constructors

	/** default constructor */
	public TFunction() {
	}

	/** minimal constructor */
	public TFunction(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TFunction(Integer id, String name, Integer pid, String url,
			Integer sort, String iconCls, Integer status, String description,
			Timestamp createdate, Timestamp updatedatetime, Integer creater,
			Integer modifyer, Integer type, Set<TRoleFunc> TRoleFuncs) {
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.url = url;
		this.sort = sort;
		this.iconCls = iconCls;
		this.status = status;
		this.description = description;
		this.createdate = createdate;
		this.updatedatetime = updatedatetime;
		this.creater = creater;
		this.modifyer = modifyer;
		this.type = type;
		this.TRoleFuncs = TRoleFuncs;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "url", length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "iconCls", length = 50)
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "createdate", length = 19)
	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "updatedatetime", length = 19)
	public Timestamp getUpdatedatetime() {
		return this.updatedatetime;
	}

	public void setUpdatedatetime(Timestamp updatedatetime) {
		this.updatedatetime = updatedatetime;
	}

	@Column(name = "creater")
	public Integer getCreater() {
		return this.creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	@Column(name = "modifyer")
	public Integer getModifyer() {
		return this.modifyer;
	}

	public void setModifyer(Integer modifyer) {
		this.modifyer = modifyer;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TFunction")
	public Set<TRoleFunc> getTRoleFuncs() {
		return this.TRoleFuncs;
	}

	public void setTRoleFuncs(Set<TRoleFunc> TRoleFuncs) {
		this.TRoleFuncs = TRoleFuncs;
	}

}