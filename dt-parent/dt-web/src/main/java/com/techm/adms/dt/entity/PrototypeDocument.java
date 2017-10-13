package com.techm.adms.dt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="prototypedocument")
public class PrototypeDocument implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Protototype_DocId")
	private int prototypeDocumentId;
	
	@Column(name="DocumentID")
	private String documentId;
	
	@Column(name="DocumentName")
	private String documentName;
	
	@OneToOne(fetch=FetchType.EAGER, targetEntity=MediaType.class)
	@JoinColumn(name="MediaTypeID", referencedColumnName="MediaTypeID")
	private MediaType mediaType;
	
	@Column(name="PrototypeId")
	private int prototypeId;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="UID")
	private String uniqueId;

	public int getPrototypeDocumentId() {
		return prototypeDocumentId;
	}

	public void setPrototypeDocumentId(int prototypeDocumentId) {
		this.prototypeDocumentId = prototypeDocumentId;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public int getPrototypeId() {
		return prototypeId;
	}

	public void setPrototypeId(int prototypeId) {
		this.prototypeId = prototypeId;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String toString() {
		return "PrototypeDocument [prototypeDocumentId=" + prototypeDocumentId
				+ ", documentId=" + documentId + ", documentName="
				+ documentName + ", mediaType=" + mediaType + ", prototypeId="
				+ prototypeId + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
