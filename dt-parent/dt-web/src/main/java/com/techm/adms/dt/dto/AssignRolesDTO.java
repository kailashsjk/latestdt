package com.techm.adms.dt.dto;

public class AssignRolesDTO {

	private int userId;
	private String userName;
	private String[] permissions;
	private Integer[] permissionsId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String[] getPermissions() {
		return permissions;
	}
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	public Integer[] getPermissionsId() {
		return permissionsId;
	}
	public void setPermissionsId(Integer[] permissionsId) {
		this.permissionsId = permissionsId;
	}
	@Override
	public String toString() {
		return "AssignRolesDTO [userId=" + userId
				+ ", userName=" + userName + ", permissions=" + permissions
				+ ", permissionsId=" + permissionsId + "]";
	}

	
}
