package com.techm.adms.dt.entity;

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
@Table(name = "needorinsight")
public class NeedsOrInsight {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NOI_ID")
	private int noiId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Project.class)
	@JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
	private Project project;

	@Column(name = "Description")
	private String description;

	@Column(name = "Need_OR_Insight")
	private String needOrInsight;

	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user;

	@Column(name = "DeleteFlag")
	private int deleteFlag;

	@Column(name = "CreatedDate", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	public int getNoiId() {
		return noiId;
	}

	public void setNoiId(int noiId) {
		this.noiId = noiId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNeedOrInsight() {
		return needOrInsight;
	}

	public void setNeedOrInsight(String needOrInsight) {
		this.needOrInsight = needOrInsight;
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
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "NeedsOrInsight [noiId=" + noiId + ", project=" + project
				+ ", description=" + description + ", needOrInsight="
				+ needOrInsight + ", user=" + user + ", deleteFlag="
				+ deleteFlag + ", createDate=" + createDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
