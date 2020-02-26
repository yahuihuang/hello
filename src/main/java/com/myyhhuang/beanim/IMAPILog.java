package com.myyhhuang.beanim;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMAPILog")
public class IMAPILog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Seqno")
	private int seqno;
	
	//1.收到的資料
	@Column(name = "ApplyStatus")
	private int applyStatus;
	
	@Column(name = "ApplyKind")
	private int applyKind;
	
	@Column(name = "ApplyTime")
	private Date applyTime;
	
	@Column(name = "ApplyData")
	private String applyData;
	
	@Column(name = "ApplyEmp")
	private String applyEmp;
	
	@Column(name = "ApplyIp")
	private String applyIp;
	
	//2.送出的查詢
	@Column(name = "RequestTime")
	private Date requestTime;
	
	@Column(name = "RequestData")
	private String requestData;
	
	@Column(name = "RequestUrl")
	private String requestUrl;
	
	//3.查詢回覆
	@Column(name = "ResponseTime")
	private Date responseTime;
	
	@Column(name = "responseData")
	private String responseData;
	
	@Column(name = "HttpCode")
	private String httpCode;
	
	public IMAPILog() {
		
	}

	public IMAPILog(int applyStatus, int applyKind, Date applyTime, String applyData, String applyEmp, String applyIp) {
		super();
		this.applyStatus = applyStatus;
		this.applyKind = applyKind;
		this.applyTime = applyTime;
		this.applyData = applyData;
		this.applyEmp = applyEmp;
		this.applyIp = applyIp;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}

	public int getApplyKind() {
		return applyKind;
	}

	public void setApplyKind(int applyKind) {
		this.applyKind = applyKind;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyData() {
		return applyData;
	}

	public void setApplyData(String applyData) {
		this.applyData = applyData;
	}

	public String getApplyEmp() {
		return applyEmp;
	}

	public void setApplyEmp(String applyEmp) {
		this.applyEmp = applyEmp;
	}

	public String getApplyIp() {
		return applyIp;
	}

	public void setApplyIp(String applyIp) {
		this.applyIp = applyIp;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "IMAPILog [seqno=" + seqno + ", applyStatus=" + applyStatus + ", applyKind=" + applyKind + ", applyTime="
				+ applyTime + ", applyData=" + applyData + ", applyEmp=" + applyEmp + ", applyIp=" + applyIp
				+ ", requestTime=" + requestTime + ", requestData=" + requestData + ", requestUrl=" + requestUrl
				+ ", responseTime=" + responseTime + ", responseData=" + responseData + ", httpCode=" + httpCode + "]";
	}
}
