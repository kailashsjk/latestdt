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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="idea")
public class Idea implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdeaId")
	private int ideaId;
	
	@ManyToOne(targetEntity=Project.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private Project project;
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	@Column(name="IdeaDescription")
	private String ideaDescription;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user; 
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate; 
	
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
	@Override
	public String toString() {
		return "Idea [ideaId=" + ideaId + ", project=" + project
				+ ", ideaDescription=" + ideaDescription + ", deleteFlag="
				+ deleteFlag + ", createdDate=" + createdDate + ", user="
				+ user + ", updatedDate=" + updatedDate + "]";
	}

}
