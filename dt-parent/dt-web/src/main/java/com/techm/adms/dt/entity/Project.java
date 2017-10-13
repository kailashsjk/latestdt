package com.techm.adms.dt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="project")
public class Project implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public Project() {
		super();
	}
	@Id
	@Column(name="ProjectID")
	private int projectId;

	@Column(name="ProjectName")
	private String projectName;
	
	@Column(name="ResearchAgenda")
	private String researchAgenda;
	
	@Column(name="ProjectStatus")
	private int projectStatus;
	
	//@Column(name="ProjectStage")
	@ManyToOne(targetEntity=ProjectStage.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "ProjectStage", referencedColumnName = "ProjectStageID")
	private ProjectStage projectStage;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id")
	private User user;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="ProjID")
	private String projId;
	
	@Column(name="IBUName")
	private String ibuName;
	
	@Column(name="AccountName")
	private String accountName;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	public String getResearchAgenda() {
		return researchAgenda;
	}

	public void setResearchAgenda(String researchAgenda) {
		this.researchAgenda = researchAgenda;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ProjectStage getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(ProjectStage projectStage) {
		this.projectStage = projectStage;
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

	public String getIbuName() {
		return ibuName;
	}

	public void setIbuName(String ibuName) {
		this.ibuName = ibuName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", researchAgenda=" + researchAgenda
				+ ", projectStatus=" + projectStatus + ", projectStage="
				+ projectStage + ", user=" + user + ", deleteFlag="
				+ deleteFlag + ", projId=" + projId + ", ibuName=" + ibuName
				+ ", accountName=" + accountName + ", createdDate="
				+ createdDate + "]";
	}


}
