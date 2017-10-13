package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

public class HmwQuestionsDTO {
	
	private String questionDescription;
	private String createdBy;
	private Date createdDate;
	private int projectId;
	private int questionID;
	private int deleteFlag;
	private String questionDescriptionShort;

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
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
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getQuestionDescriptionShort() {
		return doSubstring(questionDescription, 100);
	}

	public void setQuestionDescriptionShort(String questionDescriptionShort) {
		this.questionDescriptionShort = questionDescriptionShort;
	}

	@Override
	public String toString() {
		return "HmwQuestionsDTO [questionDescription=" + questionDescription
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", projectId=" + projectId + ", questionID=" + questionID
				+ ", deleteFlag=" + deleteFlag + ", questionDescriptionShort="
				+ questionDescriptionShort + "]";
	}
}
