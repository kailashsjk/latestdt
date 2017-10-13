package com.techm.adms.dt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class PersonaDocument implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PersonaID")
	private int personaID;

	@Column(name="DocumentID")
	private String documentId;
	
	@Column(name="DocumentName")
	private String documentName;
	
	@Column(name="MediaID")
	private int mediaId;
	
	@Column(name="UID")
	private String uniqueId;

	public int getPersonaID() {
		return personaID;
	}

	public void setPersonaID(int personaID) {
		this.personaID = personaID;
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
		return "PersonaDocument [personaID=" + personaID + ", documentId="
				+ documentId + ", documentName=" + documentName + ", mediaId="
				+ mediaId + ", uniqueId=" + uniqueId + "]";
	}
	
}
