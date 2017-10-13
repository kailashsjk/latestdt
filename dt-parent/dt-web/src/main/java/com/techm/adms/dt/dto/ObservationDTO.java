package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;


public class ObservationDTO {

	private int observationID;
	private String observationNotes;
	private int observationCategoryID ;
	private String categoryDescription ;
	private String intervieweeName;	
	private String mediaType;
	private String mediaInputs;
	private String documentID;
	private String createdBy;
	private Date createdDate;
	private Date updatedDate;
	private String updatedBy;
	private int deleteFlag;
	private String jobType;
	private String observationNotesShort;
	
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	public int getObservationID() {
		return observationID;
	}
	public void setObservationID(int observationID) {
		this.observationID = observationID;
	}
	public String getObservationNotes() {
		return observationNotes;
	}
	public void setObservationNotes(String observationNotes) {
		this.observationNotes = observationNotes;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getIntervieweeName() {
		return intervieweeName;
	}
	public void setIntervieweeName(String intervieweeName) {
		this.intervieweeName = intervieweeName;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getMediaInputs() {
		return mediaInputs;
	}
	public void setMediaInputs(String mediaInputs) {
		this.mediaInputs = mediaInputs;
	}
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
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
	
	public int getObservationCategoryID() {
		return observationCategoryID;
	}
	public void setObservationCategoryID(int observationCategoryID) {
		this.observationCategoryID = observationCategoryID;
	}
	
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getObservationNotesShort() {
		return doSubstring(observationNotes, 100);
	}
	public void setObservationNotesShort(String observationNotesShort) {
		this.observationNotesShort = observationNotesShort;
	}
	@Override
	public String toString() {
		return "ObservationDTO [observationID=" + observationID
				+ ", observationNotes=" + observationNotes
				+ ", observationCategoryID=" + observationCategoryID
				+ ", categoryDescription=" + categoryDescription
				+ ", intervieweeName=" + intervieweeName + ", mediaType="
				+ mediaType + ", mediaInputs=" + mediaInputs + ", documentID="
				+ documentID + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + ", deleteFlag=" + deleteFlag + ", jobType="
				+ jobType + ", observationNotesShort=" + observationNotesShort
				+ "]";
	}
}
