package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.AssignRolesDTO;
import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.User;

@Named
public class AssignRolesConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignRolesConversation.class);
	public AssignRolesDTO fromEntityToDTO(List<AssignRoles> rolesList){
		AssignRolesDTO assignRolesDTO = null;
		List<String> rolesDesc=new ArrayList<String>();
		String[] rolesDescArray= new String[rolesDesc.size()];
		List<Integer> rolesIds=new ArrayList<Integer>();
		Integer[] rolesIdsArray= new Integer[rolesIds.size()];
		if(rolesList != null && rolesList.size() >0){
			for(AssignRoles assignRoles:rolesList){
				assignRolesDTO = new AssignRolesDTO();
				assignRolesDTO.setUserId(assignRoles.getLogInUser().getId());
				assignRolesDTO.setUserName(assignRoles.getLogInUser().getUserId()); 
				rolesDesc.clear();
				rolesIds.clear();
				for(AssignRoles assignRoles1:rolesList){
					rolesDesc.add(assignRoles1.getRoles().getRoleDescription());
					assignRolesDTO.setPermissions(rolesDesc.toArray(rolesDescArray));
					rolesIds.add(assignRoles1.getRoles().getId());
					assignRolesDTO.setPermissionsId(rolesIds.toArray(rolesIdsArray));
				}
			}
		}
		return assignRolesDTO;
		
	}
	
	public List<AssignRolesDTO> fromEntityToDTO2(List<AssignRoles> rolesList, List<User> userList){
		List<AssignRolesDTO> assignRolesDTOList = new ArrayList<AssignRolesDTO>();
		List<String> rolesDesc=new ArrayList<String>();
		String[] rolesDescArray= new String[rolesDesc.size()];
		List<Integer> rolesIds=new ArrayList<Integer>();
		Integer[] rolesIdsArray= new Integer[rolesIds.size()];
		if(rolesList != null && rolesList.size() >0){
			AssignRolesDTO assignRolesDTO = null;
			for(User user:userList){
				assignRolesDTO = new AssignRolesDTO();
				rolesDesc.clear();
				rolesIds.clear();
				for(AssignRoles assignRoles1:rolesList){
					if(assignRoles1.getLogInUser().getId() == user.getId()){
						rolesDesc.add(assignRoles1.getRoles().getRoleDescription());
						rolesIds.add(assignRoles1.getRoles().getId());
					}
				}
				assignRolesDTO.setUserId(user.getId());
				assignRolesDTO.setUserName(user.getFirstName()+" "+ user.getLastName());
				assignRolesDTO.setPermissions(rolesDesc.toArray(rolesDescArray));
				assignRolesDTO.setPermissionsId(rolesIds.toArray(rolesIdsArray));
				assignRolesDTOList.add(assignRolesDTO);
			}
		}
		return assignRolesDTOList;
	}
	

}
