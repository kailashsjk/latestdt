package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import com.techm.adms.dt.entity.Project;

public class ProjectDTO {
	
	private Project project;
	private String projectNameShort;
	private String projId;
	private Integer[] permissionsId;
	private boolean isFacilitator;
	private boolean hasRole;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getProjectNameShort() {
		return doSubstring(project.getProjectName(), 60);
	}
	public void setProjectNameShort(String projectNameShort) {
		this.projectNameShort = projectNameShort;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public Integer[] getPermissionsId() {
		return permissionsId;
	}
	public void setPermissionsId(Integer[] permissionsId) {
		this.permissionsId = permissionsId;
	}
	public boolean getIsFacilitator() {
		return isFacilitator;
	}
	public void setIsFacilitator(boolean isFacilitator) {
		this.isFacilitator = isFacilitator;
	}
	public boolean isHasRole() {
		return hasRole;
	}
	public void setHasRole(boolean hasRole) {
		this.hasRole = hasRole;
	}
	@Override
	public String toString() {
		return "ProjectDTO [project=" + project + ", projectNameShort="
				+ projectNameShort + ", projId=" + projId + ", permissionsId="
				+ permissionsId + ", isFacilitator=" + isFacilitator
				+ ", hasRole=" + hasRole + "]";
	}
}
