package com.techm.adms.dt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="RoleName")
	private String roleName;
	
	@Column(name="RoleDescription")
	private String roleDescription;
	
	@Column(name="DeleteFlag")
	private int deleteFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName
				+ ", roleDescription=" + roleDescription + ", deleteFlag="
				+ deleteFlag + "]";
	}
}
