package com.techm.adms.dt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projectstage")
public class ProjectStage {

	@Id
	@Column(name="ProjectStageID")
	private int projectStageID;

	@Column(name="ProjectStageDescription")
	private String projectStageDescription;

	public int getProjectStageID() {
		return projectStageID;
	}

	public void setProjectStageID(int projectStageID) {
		this.projectStageID = projectStageID;
	}

	public String getProjectStageDescription() {
		return projectStageDescription;
	}

	public void setProjectStageDescription(String projectStageDescription) {
		this.projectStageDescription = projectStageDescription;
	}
	
	
}
