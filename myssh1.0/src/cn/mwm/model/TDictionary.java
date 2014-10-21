package cn.mwm.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TDictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_dictionary", catalog = "mysshe")
public class TDictionary implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String value;
	private String remark;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String creator;

	// Constructors

	/** default constructor */
	public TDictionary() {
	}

	/** minimal constructor */
	public TDictionary(Integer id, Integer type, String value) {
		this.id = id;
		this.type = type;
		this.value = value;
	}

	/** full constructor */
	public TDictionary(Integer id, Integer type, String value, String remark,
			Timestamp createDate, Timestamp updateDate, String creator) {
		this.id = id;
		this.type = type;
		this.value = value;
		this.remark = remark;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.creator = creator;
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

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "value", nullable = false, length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "updateDate", length = 19)
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "creator", length = 50)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}