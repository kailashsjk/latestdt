package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.AssignRoles;


public interface IDTAssignedRolesDAO extends IBaseDAO<AssignRoles, Serializable>{

	public List<AssignRoles> getUserRolesbyProjectId(int projectId, int userId);
	
	public List<AssignRoles> getUserRolesbyProjectId(int projectId);

	public List<AssignRoles> getUserRolesbyUserId(int userId);

	}
