package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

public class PrototypeDTO {
	
	
	private String IGName;
	private String IGNameShort;
	private String prototypeDescription;
	private String prototypeDescriptionShort;
	private String createdBy;
	private Date createdDate;
	private int IGID;
	private int prototypeId;
	private Date UpdatedDate;
	private int deleteFlag;
	private String prototypeStatus;
	private int test;
	private boolean mediaFlag=false;
	
	
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getIGName() {
		return IGName;
	}
	public void setIGName(String iGName) {
		IGName = iGName;
	}
	public String getIGNameShort() {
		return doSubstring(IGName, 50);
	}
	public void setIGNameShort(String iGNameShort) {
		IGNameShort = iGNameShort;
	}
	public int getIGID() {
		return IGID;
	}
	public void setIGID(int iGID) {
		IGID = iGID;
	}
	public String getPrototypeDescription() {
		return prototypeDescription;
	}
	public void setPrototypeDescription(String prototypeDescription) {
		this.prototypeDescription = prototypeDescription;
	}
	
	public String getPrototypeDescriptionShort() {
		return doSubstring(prototypeDescription,50);
	}
	public void setPrototypeDescriptionShort(String prototypeDescriptionShort) {
		this.prototypeDescriptionShort = prototypeDescriptionShort;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}
	
	public Date getUpdatedDate() {
		return UpdatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}
	
	public String getPrototypeStatus() {
		return prototypeStatus;
	}
	public void setPrototypeStatus(String prototypeStatus) {
		this.prototypeStatus = prototypeStatus;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	
	public boolean isMediaFlag() {
		return mediaFlag;
	}
	public void setMediaFlag(boolean mediaFlag) {
		this.mediaFlag = mediaFlag;
	}
	@Override
	public String toString() {
		return "PrototypeDTO [IGName=" + IGName + ", prototypeDescription="
				+ prototypeDescription + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", IGID=" + IGID
				+ ", prototypeId=" + prototypeId + ", UpdatedDate="
				+ UpdatedDate + ", deleteFlag=" + deleteFlag
				+ ", prototypeStatus=" + prototypeStatus + ", test=" + test
				+ ", mediaFlag=" + mediaFlag + "]";
	}
}
