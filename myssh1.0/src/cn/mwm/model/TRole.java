package cn.mwm.model;

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
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role", catalog = "mysshe")
public class TRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String description;
	private String name;
	private Integer type;
	private String code;
	private Set<TRoleFunc> TRoleFuncs = new HashSet<TRoleFunc>(0);
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Integer id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	/** full constructor */
	public TRole(Integer id, String description, String name, Integer type,
			String code, Set<TRoleFunc> TRoleFuncs, Set<TUserRole> TUserRoles) {
		this.id = id;
		this.description = description;
		this.name = name;
		this.type = type;
		this.code = code;
		this.TRoleFuncs = TRoleFuncs;
		this.TUserRoles = TUserRoles;
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

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "code", nullable = false, length = 20)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TRoleFunc> getTRoleFuncs() {
		return this.TRoleFuncs;
	}

	public void setTRoleFuncs(Set<TRoleFunc> TRoleFuncs) {
		this.TRoleFuncs = TRoleFuncs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

}