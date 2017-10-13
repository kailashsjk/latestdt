package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

public class PrototypeFeedbackDTO {

	private int prototypeFeedbackID;
	
	private String questionDescription;
	private String ideaDescription;
	private String prototypeDescription;
	private String prototypeFeedbackDescription;
	private String createdBy;
	private Date createdDate;
	private int projectStage;
	private int ideaGroupId;
	private int prototypeId;
	private int questionID;
	private String IGName;
	private int IGID;
	private int deleteFlag;
	private boolean mediaFlag = false;
	private String prototypeDescriptionShort;
	private String prototypeFeedbackDescriptionShort;
	private String IGNameShort;
	
	
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
	public int getIGID() {
		return IGID;
	}
	public void setIGID(int iGID) {
		IGID = iGID;
	}
	 public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}

	public int getIdeaGroupId() {
		return ideaGroupId;
	}
	public void setIdeaGroupId(int ideaGroupId) {
		this.ideaGroupId = ideaGroupId;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getPrototypeFeedbackID() {
		return prototypeFeedbackID;
	}
	public void setPrototypeFeedbackID(int prototypeFeedbackID) {
		this.prototypeFeedbackID = prototypeFeedbackID;
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
	public String getPrototypeDescription() {
		return prototypeDescription;
	}
	public void setPrototypeDescription(String prototypeDescription) {
		this.prototypeDescription = prototypeDescription;
	}
	public String getPrototypeFeedbackDescription() {
		return prototypeFeedbackDescription;
	}
	public void setPrototypeFeedbackDescription(String prototypeFeedbackDescription) {
		this.prototypeFeedbackDescription = prototypeFeedbackDescription;
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
	public int getProjectStage() {
		return projectStage;
	}
	public void setProjectStage(int projectStage) {
		this.projectStage = projectStage;
	}
	
	public boolean isMediaFlag() {
		return mediaFlag;
	}
	public void setMediaFlag(boolean mediaFlag) {
		this.mediaFlag = mediaFlag;
	}
	public String getPrototypeDescriptionShort() {
		return  doSubstring(prototypeDescription, 50);
	}
	public void setPrototypeDescriptionShort(String prototypeDescriptionShort) {
		this.prototypeDescriptionShort = prototypeDescriptionShort;
	}
	public String getPrototypeFeedbackDescriptionShort() {
		return doSubstring(prototypeFeedbackDescription, 100);
	}
	public void setPrototypeFeedbackDescriptionShort(
			String prototypeFeedbackDescriptionShort) {
		this.prototypeFeedbackDescriptionShort = prototypeFeedbackDescriptionShort;
	}
	public String getIGNameShort() {
		return doSubstring(IGName, 50);
	}
	public void setIGNameShort(String iGNameShort) {
		IGNameShort = iGNameShort;
	}
	@Override
	public String toString() {
		return "PrototypeFeedbackDTO [prototypeFeedbackID="
				+ prototypeFeedbackID + ", questionDescription="
				+ questionDescription + ", ideaDescription=" + ideaDescription
				+ ", prototypeDescription=" + prototypeDescription
				+ ", prototypeFeedbackDescription="
				+ prototypeFeedbackDescription + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", projectStage="
				+ projectStage + ", ideaGroupId=" + ideaGroupId
				+ ", prototypeId=" + prototypeId + ", questionID=" + questionID
				+ ", IGName=" + IGName + ", IGID=" + IGID + ", deleteFlag="
				+ deleteFlag + ", mediaFlag=" + mediaFlag
				+ ", prototypeDescriptionShort=" + prototypeDescriptionShort
				+ ", prototypeFeedbackDescriptionShort="
				+ prototypeFeedbackDescriptionShort + ", IGNameShort="
				+ IGNameShort + "]";
	}
}
