package com.techm.adms.dt.dto;
import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;
public class IdeaDTO {
	
	private int ideaId;
	private int projectId;
    private String ideaDescription;
    private String ideaDescriptionShort;
	private Date createdDate;
	private String createdBy;
	private int deleteFlag;
	
    public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaDescription() {
		return ideaDescription;
	}

	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}

	public String getIdeaDescriptionShort() {
		return doSubstring(ideaDescription, 50);
	}

	public void setIdeaDescriptionShort(String ideaDescriptionShort) {
		this.ideaDescriptionShort = ideaDescriptionShort;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "IdeaDTO [ideaId=" + ideaId + ", projectId=" + projectId
				+ ", ideaDescription=" + ideaDescription
				+ ", ideaDescriptionShort=" + ideaDescriptionShort
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", deleteFlag=" + deleteFlag + "]";
	}
}
