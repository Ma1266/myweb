package cn.mwm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TRoleFunc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role_func", catalog = "mysshe")
public class TRoleFunc implements java.io.Serializable {

	// Fields

	private Integer id;
	private TFunction TFunction;
	private TRole TRole;

	// Constructors

	/** default constructor */
	public TRoleFunc() {
	}

	/** minimal constructor */
	public TRoleFunc(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TRoleFunc(Integer id, TFunction TFunction, TRole TRole) {
		this.id = id;
		this.TFunction = TFunction;
		this.TRole = TRole;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "func_id")
	public TFunction getTFunction() {
		return this.TFunction;
	}

	public void setTFunction(TFunction TFunction) {
		this.TFunction = TFunction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

}