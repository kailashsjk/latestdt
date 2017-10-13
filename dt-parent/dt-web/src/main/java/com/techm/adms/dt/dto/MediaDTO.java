package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.util.Date;

public class MediaDTO {
	
	private String techiniqueUsed;
	private String jobType;
	private String inputNotes;
	private Date updatedDate;
	private String mediaType;
	private int mediaId; 
	private Date createdDate;
	private int deleteFlag;
	private String intervieweeName;
	private String mediaName; 
	private String inputNotesShort;
	private boolean personaFlag;
		
	public String getIntervieweeName() {
		return intervieweeName;
	}
	public void setIntervieweeName(String intervieweeName) {
		this.intervieweeName = intervieweeName;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public String getTechiniqueUsed() {
		return techiniqueUsed;
	}
	public void setTechiniqueUsed(String techiniqueUsed) {
		this.techiniqueUsed = techiniqueUsed;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getInputNotes() {
		return inputNotes;
	}
	public void setInputNotes(String inputNotes) {
		this.inputNotes = inputNotes;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getInputNotesShort() {
		return doSubstring(inputNotes, 50);
	}
	public void setInputNotesShort(String inputNotesShort) {
		this.inputNotesShort = inputNotesShort;
	}
	
	public boolean getPersonaFlag() {
		return personaFlag;
	}
	public void setPersonaFlag(boolean personaFlag) {
		this.personaFlag = personaFlag;
	}
	@Override
	public String toString() {
		return "MediaDTO [techiniqueUsed=" + techiniqueUsed + ", jobType="
				+ jobType + ", inputNotes=" + inputNotes + ", updatedDate="
				+ updatedDate + ", mediaType=" + mediaType + ", mediaId="
				+ mediaId + ", createdDate=" + createdDate + ", deleteFlag="
				+ deleteFlag + ", intervieweeName=" + intervieweeName
				+ ", mediaName=" + mediaName + ", inputNotesShort="
				+ inputNotesShort + ", personaFlag=" + personaFlag + "]";
	}

}
