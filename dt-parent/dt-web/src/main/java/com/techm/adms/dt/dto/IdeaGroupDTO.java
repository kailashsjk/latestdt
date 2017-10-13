package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

import com.techm.adms.dt.entity.User;

public class IdeaGroupDTO {
	
	private int projectId;
	private int protyping;
	private int deleteFlag;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String IGName;
	private String IGNameShort;
	private int IGID;
	
	public int getIGID() {
		return IGID;
	}

	public void setIGID(int iGID) {
		IGID = iGID;
	}
	public String getIGName() {
		return IGName;
	}
	public void setIGName(String iGName) {
		IGName = iGName;
	}
	public String getIGNameShort() {
		return doSubstring(IGName, 40);
	}

	public void setIGNameShort(String iGNameShort) {
		IGNameShort = iGNameShort;
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getProtyping() {
		return protyping;
	}
	public void setProtyping(int protyping) {
		this.protyping = protyping;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "IdeaGroupDTO [projectId=" + projectId + ", protyping="
				+ protyping + ", deleteFlag=" + deleteFlag + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
	

}
