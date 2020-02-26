package com.myyhhuang.beanim;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMCounty")
public class IMCounty implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CountyCode")
	private String countyCode;
	
	@Column(name = "CountyName")
	private String countyName;
	
	@Column(name = "ModifyTime")
	private Date modifyTime;
	
	@Column(name = "ModifyEmp")
	private String modifyEmp;
	
	public IMCounty() {
		
	}

	public IMCounty(String countyCode) {
		super();
		this.countyCode = countyCode;
	}

	public IMCounty(String countyCode, String countyName, Date modifyTime, String modifyEmp) {
		super();
		this.countyCode = countyCode;
		this.countyName = countyName;
		this.modifyTime = modifyTime;
		this.modifyEmp = modifyEmp;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyEmp() {
		return modifyEmp;
	}

	public void setModifyEmp(String modifyEmp) {
		this.modifyEmp = modifyEmp;
	}

	/*
	public CountyType copy() {
		CountyType countyType = new CountyType();
		
		countyType.setCountyCode(this.countyCode);
		countyType.setCountyName(this.countyName);
		
		return countyType;
	}*/

	@Override
	public String toString() {
		return "IMCounty [countyCode=" + countyCode + ", countyName=" + countyName + ", modifyTime=" + modifyTime
				+ ", modifyEmp=" + modifyEmp + "]";
	}
}
