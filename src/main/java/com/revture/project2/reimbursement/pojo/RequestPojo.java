package com.revture.project2.reimbursement.pojo;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequestPojo {
	
	
	private int id; 
	@NotNull
	private String reqName; 
	
	@NotNull
	@Min(0)
	private int reqPrice; 
	
	@NotNull
	private String reqDescription; 
	private boolean reqFlag; 
	private Date reqDate;
	private LocalDate acceptDate;
	private String img; 
	private int usersId;
	private boolean reject;
	
	public RequestPojo() {
		super();

	}

	public RequestPojo(int id, String reqName, int reqPrice, String reqDescription, boolean reqFlag, Date reqDate,
			LocalDate acceptDate, String img, int usersId, boolean reject) {
		super();
		this.id = id;
		this.reqName = reqName;
		this.reqPrice = reqPrice;
		this.reqDescription = reqDescription;
		this.reqFlag = reqFlag;
		this.reqDate = reqDate;
		this.acceptDate = acceptDate;
		this.img = img;
		this.usersId = usersId;
		this.reject = reject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public int getReqPrice() {
		return reqPrice;
	}

	public void setReqPrice(int reqPrice) {
		this.reqPrice = reqPrice;
	}

	public String getReqDescription() {
		return reqDescription;
	}

	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}

	public boolean isReqFlag() {
		return reqFlag;
	}

	public void setReqFlag(boolean reqFlag) {
		this.reqFlag = reqFlag;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public LocalDate getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(LocalDate acceptDate) {
		this.acceptDate = acceptDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public boolean isReject() {
		return reject;
	}

	public void setReject(boolean reject) {
		this.reject = reject;
	}


	@Override
	public String toString() {
		return "RequestPojo [id=" + id + ", reqName=" + reqName + ", reqPrice=" + reqPrice + ", reqDescription="
				+ reqDescription + ", reqFlag=" + reqFlag + ", reqDate=" + reqDate + ", acceptDate=" + acceptDate
				+ ", img=" + img + ", usersId=" + usersId + ", reject=" + reject + "]";
	}

	
	

	
	

	
	
	
	

}
