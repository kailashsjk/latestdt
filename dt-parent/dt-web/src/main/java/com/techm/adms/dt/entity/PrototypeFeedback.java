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


@Entity
@Table(name="prototypefeedback")
public class PrototypeFeedback implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PrototypeFeedbackID")
	private int prototypeFeedbackID;

	@Column(name="PrototypeFeedbackDescription")
	private String prototypeFeedbackDescription;
	
	@ManyToOne(targetEntity=Prototype.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "PrototypeID", referencedColumnName = "PrototypeID")
	private Prototype prototype;
	

	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user;
	
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	public int getPrototypeFeedbackID() {
		return prototypeFeedbackID;
	}

	public void setPrototypeFeedbackID(int prototypeFeedbackID) {
		this.prototypeFeedbackID = prototypeFeedbackID;
	}

	public String getPrototypeFeedbackDescription() {
		return prototypeFeedbackDescription;
	}

	public void setPrototypeFeedbackDescription(String prototypeFeedbackDescription) {
		this.prototypeFeedbackDescription = prototypeFeedbackDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Prototype getPrototype() {
		return prototype;
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
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
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "PrototypeFeedback [prototypeFeedbackID=" + prototypeFeedbackID
				+ ", prototypeFeedbackDescription="
				+ prototypeFeedbackDescription + ", prototype=" + prototype
				+ ", user=" + user + ", deleteFlag=" + deleteFlag
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	
	
	

}
