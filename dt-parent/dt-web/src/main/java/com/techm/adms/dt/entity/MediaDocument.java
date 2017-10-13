package com.techm.adms.dt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mediadocument")
public class MediaDocument implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MDID")
	private int mdId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MediaTypeID", referencedColumnName="MediaTypeID")
	private MediaType mediaType;
		
	@Column(name="MediaName")
	private String mediaName;
	
	@Column(name="DocumentID")
	private String documentID;		
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id")
	private User user;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="MediaID")
	private int mediaId;
	
	@Column(name="UID")
	private String uniqueId;

	public int getMdId() {
		return mdId;
	}

	public void setMdId(int mdId) {
		this.mdId = mdId;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}


	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
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

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String toString() {
		return "MediaDocument [mdId=" + mdId + ", mediaType=" + mediaType
				+ ", mediaName="
				+ mediaName + ", documentID=" + documentID + ", user=" + user
				+ ", deleteFlag=" + deleteFlag + ", createdDate=" + createdDate
				+ ", mediaId=" + mediaId + "]";
	}

}
