package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.techm.adms.dt.dto.ProjectDTO;
import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.Project;

@Named
public class ProjectConversation {
	public List<ProjectDTO> fromEntityToDTO3(List<AssignRoles> rolesList, List<Project> projectList){
		ProjectDTO assignedRolesBasedOnUserIdDTO=null;
		List<ProjectDTO> assignedRolesBasedOnUserIdDTOsList= new ArrayList<ProjectDTO>();
		/*List<String> rolesDesc=new ArrayList<String>();
		String[] rolesDescArray= new String[rolesDesc.size()];*/
		List<Integer> rolesIds=new ArrayList<Integer>();
		Integer[] rolesIdsArray= new Integer[rolesIds.size()];
		
		
			for(Project project: projectList){
				assignedRolesBasedOnUserIdDTO=new ProjectDTO();
				//rolesDesc.clear();
				rolesIds.clear();
				for(AssignRoles assignRoles: rolesList){
					if(assignRoles.getProject().getProjectId() == project.getProjectId()){ 
						//rolesDesc.add(assignRoles.getRoles().getRoleDescription()); 
						rolesIds.add(assignRoles.getRoles().getId());
							if(assignRoles.getRoles().getId() == 2){
								assignedRolesBasedOnUserIdDTO.setIsFacilitator(true);
							}
					}
				}
				if(rolesIds.size() != 0){
					assignedRolesBasedOnUserIdDTO.setHasRole(true);
				}else{
					assignedRolesBasedOnUserIdDTO.setHasRole(false);
				}
				
				assignedRolesBasedOnUserIdDTO.setProject(project);
				//assignedRolesBasedOnUserIdDTO.setProjectNameShort(subStringUtil.doSubstring(project.getProjectName(), 45));
				assignedRolesBasedOnUserIdDTO.setProjId(project.getProjId());
				assignedRolesBasedOnUserIdDTO.setPermissionsId(rolesIds.toArray(rolesIdsArray));
				//assignedRolesBasedOnUserIdDTO.setPermissions(rolesDesc.toArray(rolesDescArray));
				assignedRolesBasedOnUserIdDTOsList.add(assignedRolesBasedOnUserIdDTO);
			}
		return assignedRolesBasedOnUserIdDTOsList;
	}
}
