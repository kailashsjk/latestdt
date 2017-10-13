package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

public class IdeaFeedbackDTO {
	private int ideaFeedbackID;
	private String questionDescription;
	private String ideaDescription;
	private String ideaFeedbackDescription;
	private String ideaDescriptionShort;
	private String ideaFeedbackDescriptionShort;
	private String createdBy;
	private Date createdDate;
	private int ideaCategoryId;
	private int deleteFlag;
	private String ideaCategoryDescription;
	
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public int getIdeaCategoryId() {
		return ideaCategoryId;
	}
	public void setIdeaCategoryId(int ideaCategoryId) {
		this.ideaCategoryId = ideaCategoryId;
	}
	public String getIdeaCategoryDescription() {
		return ideaCategoryDescription;
	}
	public void setIdeaCategoryDescription(String ideaCategoryDescription) {
		this.ideaCategoryDescription = ideaCategoryDescription;
	}

	public int getIdeaFeedbackID() {
		return ideaFeedbackID;
	}
	public void setIdeaFeedbackID(int ideaFeedbackID) {
		this.ideaFeedbackID = ideaFeedbackID;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getIdeaDescription() {
		return ideaDescription;
	}
	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}
	public String getIdeaFeedbackDescription() {
		return ideaFeedbackDescription;
	}
	public void setIdeaFeedbackDescription(String ideaFeedbackDescription) {
		this.ideaFeedbackDescription = ideaFeedbackDescription;
	}
	public String getIdeaDescriptionShort() {
		return doSubstring(ideaDescription, 50);
	}
	public void setIdeaDescriptionShort(String ideaDescriptionShort) {
		this.ideaDescriptionShort = ideaDescriptionShort;
	}
	public String getIdeaFeedbackDescriptionShort() {
		return doSubstring(ideaFeedbackDescription, 50);
	}
	public void setIdeaFeedbackDescriptionShort(String ideaFeedbackDescriptionShort) {
		this.ideaFeedbackDescriptionShort = ideaFeedbackDescriptionShort;
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
	@Override
	public String toString() {
		return "IdeaFeedbackDTO [ideaFeedbackID=" + ideaFeedbackID
				+ ", questionDescription=" + questionDescription
				+ ", ideaDescription=" + ideaDescription
				+ ", ideaFeedbackDescription=" + ideaFeedbackDescription
				+ ", ideaDescriptionShort=" + ideaDescriptionShort
				+ ", ideaFeedbackDescriptionShort="
				+ ideaFeedbackDescriptionShort + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", ideaCategoryId="
				+ ideaCategoryId + ", deleteFlag=" + deleteFlag
				+ ", ideaCategoryDescription=" + ideaCategoryDescription + "]";
	}	
}
