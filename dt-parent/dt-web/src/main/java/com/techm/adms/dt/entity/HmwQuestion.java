package com.techm.adms.dt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="hmwquestion")
public class HmwQuestion implements Serializable {
	@Override
	public String toString() {
		return "HmwQuestion [questionID=" + questionID + ", project=" + project
				+ ", questionDescription=" + questionDescription + ", user="
				+ user + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", deleteFlag=" + deleteFlag + "]";
	}
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QuestionID")
    private int questionID;
	
	@ManyToOne(targetEntity=Project.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private Project project;

	
	@Column(name="QuestionDescription")
	private String questionDescription;
	
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
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

}
