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
@Table(name = "ideagroup")
public class IdeaGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IGID")
	private int IGID;

	@ManyToOne(targetEntity = Project.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private Project project;

	@Column(name = "IGName")
	private String IGName;

	@Column(name = "Protyping")
	private int protyping;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
			@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id") })
	private User user;

	@Column(name = "DeleteFlag")
	private int deleteFlag;

	@Column(name = "CreatedDate", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "UpdatedDate", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	public int getIGID() {
		return IGID;
	}

	public void setIGID(int iGID) {
		IGID = iGID;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getIGName() {
		return IGName;
	}

	public void setIGName(String iGName) {
		IGName = iGName;
	}

	public int getProtyping() {
		return protyping;
	}

	public void setProtyping(int protyping) {
		this.protyping = protyping;
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

	public Date getCreateDate() {
		return createdDate;
	}

	public void setCreateDate(Date createDate) {
		this.createdDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "IdeaGroup [IGID=" + IGID + ", project=" + project + ", IGName="
				+ IGName + ", protyping=" + protyping + ", user=" + user
				+ ", deleteFlag=" + deleteFlag + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	
}
