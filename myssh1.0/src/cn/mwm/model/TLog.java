package cn.mwm.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_log", catalog = "mysshe")
public class TLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private String eventName;
	private String eventRecord;
	private String ip;
	private Timestamp logDate;
	private String mac;
	private String name;
	private String objectId;
	private Integer objectType;
	private Integer type;
	private Integer userId;

	// Constructors

	/** default constructor */
	public TLog() {
	}

	/** minimal constructor */
	public TLog(Integer logId) {
		this.logId = logId;
	}

	/** full constructor */
	public TLog(Integer logId, String eventName, String eventRecord, String ip,
			Timestamp logDate, String mac, String name, String objectId,
			Integer objectType, Integer type, Integer userId) {
		this.logId = logId;
		this.eventName = eventName;
		this.eventRecord = eventRecord;
		this.ip = ip;
		this.logDate = logDate;
		this.mac = mac;
		this.name = name;
		this.objectId = objectId;
		this.objectType = objectType;
		this.type = type;
		this.userId = userId;
	}

	// Property accessors
	@Id
	@Column(name = "LOG_ID", unique = true, nullable = false)
	@GeneratedValue
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@Column(name = "EVENT_NAME", length = 100)
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Column(name = "EVENT_RECORD")
	public String getEventRecord() {
		return this.eventRecord;
	}

	public void setEventRecord(String eventRecord) {
		this.eventRecord = eventRecord;
	}

	@Column(name = "IP", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "LOG_DATE", length = 19)
	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	@Column(name = "MAC", length = 20)
	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Column(name = "NAME", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "OBJECT_ID", length = 100)
	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Column(name = "OBJECT_TYPE")
	public Integer getObjectType() {
		return this.objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	@Column(name = "TYPE")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "USER_ID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}