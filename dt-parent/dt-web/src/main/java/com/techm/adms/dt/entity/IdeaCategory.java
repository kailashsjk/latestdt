package com.techm.adms.dt.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="ideacategory")
public class IdeaCategory implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdeaCategoryID")
	private int ideaCategoryId;

	public int getIdeaCategoryId() {
		return ideaCategoryId;
	}


	public void setIdeaCategoryId(int ideaCategoryId) {
		this.ideaCategoryId = ideaCategoryId;
	}


	public String getIdeaCategoryDescription() {
		return ideaCategoryDescription;
	}


	public void setIdeaCategoryDescription(String ideaCategoryDescription) {
		this.ideaCategoryDescription = ideaCategoryDescription;
	}
	@Column(name="IdeaCategoryDescription")
	private String ideaCategoryDescription;
	
	
	@Override
	public String toString() {
		return "IdeaCategory [ideaCategoryId=" +ideaCategoryId+ ", ideaCategoryDescription="
				+ ideaCategoryDescription + "]";
	}

	
}
