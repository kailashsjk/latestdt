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

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="ideafeedback")
public class IdeaFeedback implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdeaFeedbackID")
	private int ideaFeedbackID;
	
	@Column(name="IdeaFeedbackDescription")
	private String ideaFeedbackDescription;
	
	@ManyToOne(targetEntity=Idea.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "IdeaID", referencedColumnName = "IdeaID")
	private Idea idea;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user;
	
		
	@ManyToOne(targetEntity=IdeaCategory.class, fetch=FetchType.EAGER)
	@JoinColumn(name="IdeaCategory", referencedColumnName="IdeaCategoryID")
	private IdeaCategory ideaCategory;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getIdeaFeedbackID() {
		return ideaFeedbackID;
	}

	public void setIdeaFeedbackID(int ideaFeedbackID) {
		this.ideaFeedbackID = ideaFeedbackID;
	}

	public String getIdeaFeedbackDescription() {
		return ideaFeedbackDescription;
	}

	public void setIdeaFeedbackDescription(String ideaFeedbackDescription) {
		this.ideaFeedbackDescription = ideaFeedbackDescription;
	}

	public Idea getIdea() {
		return idea;
	}
 
	public void setIdea(Idea idea) {
		this.idea = idea;
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

	public IdeaCategory getIdeaCategory() {
		return ideaCategory;
	}

	public void setIdeaCategory(IdeaCategory ideaCategory) {
		this.ideaCategory = ideaCategory;
	}

	@Override
	public String toString() {
		return "IdeaFeedback [ideaFeedbackID=" + ideaFeedbackID
				+ ", ideaFeedbackDescription=" + ideaFeedbackDescription
				+ ", idea=" + idea + ", user=" + user + ", ideaCategory="
				+ ideaCategory + ", deleteFlag=" + deleteFlag
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

	
}
