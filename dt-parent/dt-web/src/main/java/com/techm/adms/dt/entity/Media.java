package com.techm.adms.dt.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	/**
	 * Entity implementation class for Entity: Project
	 *
	 */
	@Entity
	@Table(name="media")
	public class Media implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="MediaID")
		private int mediaId;
	
		@ManyToOne(targetEntity=Project.class, fetch=FetchType.EAGER)
		@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
		private Project project;

		@Column(name="IntervieweeName")
		private String intervieweeName;		
		
		@Column(name="JobType")
		private String jobType;
		
		@Column(name="TechiniqueUsed")
		private String techiniqueUsed;
		
		@Column(name="InputNotes")
		private String inputNotes;
	
		@Column(name="DeleteFlag")
		private int deleteFlag;
		
		@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
		@JoinColumns({
		@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
		@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
		})
		private User user;
		
		@Column(name="CreatedDate",insertable=false)
		@Temporal(TemporalType.DATE)
		private Date createdDate;
		
		@Column(name="UpdatedDate",insertable=false)
		@Temporal(TemporalType.DATE)
		private Date updatedDate;
			
		
		@OneToMany(targetEntity=MediaDocument.class, fetch=FetchType.EAGER)
		@JoinColumn(name="MediaID",referencedColumnName="MediaID")
		private List<MediaDocument> mediaDocument;
		
		@Column(name="UID")
		private String uniqueId;
		
		@OneToOne
		//@JoinColumn(name="MediaID",referencedColumnName="MediaID")
		@PrimaryKeyJoinColumn(name="MediaID",referencedColumnName="MediaID")
		private PersonaDocument personaDocument;
		
		public int getMediaId() {
			return mediaId;
		}

		public void setMediaId(int mediaId) {
			this.mediaId = mediaId;
		}

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public String getIntervieweeName() {
			return intervieweeName;
		}

		public void setIntervieweeName(String intervieweeName) {
			this.intervieweeName = intervieweeName;
		}

		public String getJobType() {
			return jobType;
		}

		public void setJobType(String jobType) {
			this.jobType = jobType;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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
		

		public String getTechiniqueUsed() {
			return techiniqueUsed;
		}

		public void setTechiniqueUsed(String techiniqueUsed) {
			this.techiniqueUsed = techiniqueUsed;
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

		

		public List<MediaDocument> getMediaDocument() {
			return mediaDocument;
		}

		public void setMediaDocument(List<MediaDocument> mediaDocument) {
			this.mediaDocument = mediaDocument;
		}

		public String getUniqueId() {
			return uniqueId;
		}

		public void setUniqueId(String uniqueId) {
			this.uniqueId = uniqueId;
		}

		public PersonaDocument getPersonaDocument() {
			return personaDocument;
		}

		public void setPersonaDocument(PersonaDocument personaDocument) {
			this.personaDocument = personaDocument;
		}

		@Override
		public String toString() {
			return "Media [mediaId=" + mediaId + ", project=" + project
					+ ", intervieweeName=" + intervieweeName + ", jobType="
					+ jobType + ", techiniqueUsed=" + techiniqueUsed
					+ ", inputNotes=" + inputNotes + ", deleteFlag="
					+ deleteFlag + ", user=" + user + ", createdDate="
					+ createdDate + ", updatedDate=" + updatedDate
					+ ", mediaDocument=" + mediaDocument + ", uniqueId="
					+ uniqueId + ", personaDocument=" + personaDocument + "]";
		}
	}
