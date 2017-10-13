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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="prototype")
public class Prototype implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PrototypeID")
	private int prototypeId;

	@Column(name="PrototypeDescription")
	private String prototypeDescription;
	
	@ManyToOne(targetEntity=IdeaGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name ="IGID", referencedColumnName ="IGID")
	private IdeaGroup ideaGroup;
		
	@Column(name="prototypeStatus")
	private String prototypeStatus;
		
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
    @JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name="TestFlag")
	private int test;
	
	@Column(name="UID")
	private String uniqueId;
	
	@OneToMany(targetEntity=PrototypeDocument.class, fetch=FetchType.EAGER)
	@JoinColumn(name="PrototypeID",referencedColumnName="PrototypeID")
	private List<PrototypeDocument> prototypeDocuments;
	
	public int getPrototypeId() {
		return this.prototypeId;
	}

	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}

	public String getPrototypeDescription() {
		return this.prototypeDescription;
	}

	public void setPrototypeDescription(String prototypeDescription) {
		this.prototypeDescription = prototypeDescription;
	}

			
	public IdeaGroup getIdeaGroup() {
		return ideaGroup;
	}

	public void setIdeaGroup(IdeaGroup ideaGroup) {
		this.ideaGroup = ideaGroup;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getPrototypeStatus() {
		return prototypeStatus;
	}

	public void setPrototypeStatus(String prototypeStatus) {
		this.prototypeStatus = prototypeStatus;
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
	
	
	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public List<PrototypeDocument> getPrototypeDocuments() {
		return prototypeDocuments;
	}

	public void setPrototypeDocuments(List<PrototypeDocument> prototypeDocuments) {
		this.prototypeDocuments = prototypeDocuments;
	}

	@Override
	public String toString() {
		return "Prototype [prototypeId=" + prototypeId
				+ ", prototypeDescription=" + prototypeDescription
				+ ", ideaGroup=" + ideaGroup + ", prototypeStatus="
				+ prototypeStatus + ", user=" + user + ", createdDate="
				+ createdDate + ", deleteFlag=" + deleteFlag + ", updatedDate="
				+ updatedDate + ", test=" + test + ", uniqueId=" + uniqueId
				+ "]";
	}

}
