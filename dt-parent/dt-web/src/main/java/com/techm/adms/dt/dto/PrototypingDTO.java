package com.techm.adms.dt.dto;

import java.util.Date;

public class PrototypingDTO {
	
	private String questionDescription;
	private String ideaDescription;
	private String prototypeDescription;
	private String createdBy;
	private Date createdDate;
	private int ideaId;
	private int prototypeId;
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
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
		return "PrototypingDTO [questionDescription=" + questionDescription
				+ ", ideaDescription=" + ideaDescription
				+ ", prototypeDescription=" + prototypeDescription
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", ideaId=" + ideaId + ", prototypeId=" + prototypeId + "]";
	}
	public int getPrototypeId() {
		return prototypeId;
	}
	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}

}
