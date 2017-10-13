package com.techm.adms.dt.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="observationcategory")
public class ObservationCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	public ObservationCategory() {
		super();
	}
	@Id
	@Column(name="ObservationCategoryID")
	private int observationCategoryID;
	
	@Column(name="CategoryDescription")
	private String categoryDescription ;
	
	public int getObservationCategoryID() {
		return observationCategoryID;
	}
	public void setObservationCategoryID(int observationCategoryID) {
		this.observationCategoryID = observationCategoryID;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ObservationCategory [observationCategoryID="
				+ observationCategoryID + ", categoryDescription="
				+ categoryDescription + "]";
	}

}
