package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.AssignRolesDTO;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.User;

public interface IDTRolemangementBean {
	public List<User> getAllUser();

	public AssignRolesDTO retriveAllUserWithRoleAgainstProjectId(int projectId, int userId) throws DTServiceException;

	public List<AssignRolesDTO> retriveAllUserWithRole(int projectId) throws DTServiceException;

	public void updateRolesValues(int projectId, List<AssignRolesDTO> assignRolesDTOs) throws DTServiceException;

	void addFacilitatorRoleWhileProjCreation(Project project);

	/*public List<AssignedRolesBasedOnUserIdDTO> retriveAllUserWithRoleByUserId(int userId);

	public List<AssignedRolesBasedOnUserIdDTO> retriveActiveProjectsUserWithRoleByUserId(int userId);*/
}
