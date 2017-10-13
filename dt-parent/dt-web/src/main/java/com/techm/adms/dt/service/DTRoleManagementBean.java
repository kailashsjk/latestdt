package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.AssignRolesConversation;
import com.techm.adms.dt.dao.IDTAssignedRolesDAO;
import com.techm.adms.dt.dao.IDTRoleManagementDAO;
import com.techm.adms.dt.dto.AssignRolesDTO;
import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.Roles;
import com.techm.adms.dt.entity.User;
@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTRoleManagementBean implements IDTRolemangementBean{
	private static final Logger LOGGER = LoggerFactory.getLogger(DTRoleManagementBean.class);
	
	@Inject
	IDTRoleManagementDAO dtRoleManagementDAO;
	@Inject
	IDTAssignedRolesDAO dtAssignedRolesDAO;
	@Inject
	IDTProjectBean dtProjectBean;
	@Inject
	AssignRolesConversation assignRolesConversation;
	
	//ALL USERs
	@Override
	public List<User> getAllUser() {
		List<User> users = dtRoleManagementDAO.readAll();
		return users;
	}
	//ASSIGNED ROLES BASED ON PROJECTID & USERID
	@Override
	public AssignRolesDTO retriveAllUserWithRoleAgainstProjectId(int projectId, int userId) throws DTServiceException{
		try{
			List<AssignRoles> userswithroles = dtAssignedRolesDAO.getUserRolesbyProjectId(projectId, userId);
				return assignRolesConversation.fromEntityToDTO(userswithroles);
		}catch (Exception e) {
			throw new DTServiceException(e);
		}		
	}	
	//ASSIGNED ROLES BASED ON PROJECTID
	@Override
	public List<AssignRolesDTO> retriveAllUserWithRole(int projectId) throws DTServiceException{
		try{
			List<AssignRoles> userswithroles = dtAssignedRolesDAO.getUserRolesbyProjectId(projectId);
			List<User> users = dtRoleManagementDAO.readAll();
		    return assignRolesConversation.fromEntityToDTO2(userswithroles,users);
	
		}catch (Exception e) {
			throw new DTServiceException(e);
		}	
	}
	@Override
	public void updateRolesValues(int projectId, List<AssignRolesDTO> assignRolesDTOs) throws DTServiceException{
		try{
				List<AssignRoles> rolesList = dtAssignedRolesDAO.getUserRolesbyProjectId(projectId);
				LOGGER.info("rolesList::::>>>>>>"+rolesList);
			if(rolesList !=null && rolesList.size() >0){
				for(AssignRoles assignRoles:rolesList){
					dtAssignedRolesDAO.delete(assignRoles);
				}
			}
			
			User loginUser=null;
			Roles roles = new Roles();
			AssignRoles assignRoles = null;
			Project project = new Project();
			project.setProjectId(projectId);
			for(AssignRolesDTO assignRolesDTO : assignRolesDTOs){
				if(assignRolesDTO.getPermissionsId() != null && assignRolesDTO.getPermissionsId().length > 0){
					for(int i= 0;i< assignRolesDTO.getPermissionsId().length; i++){
						assignRoles =  new AssignRoles();
						
						//set the project Id
						assignRoles.setProject(project);
						
						//set the User
						loginUser = new User();
						loginUser.setId(assignRolesDTO.getUserId());
						loginUser.setUserId(assignRolesDTO.getUserName());
						assignRoles.setLogInUser(loginUser);
						
						// set the Roles
						roles = new Roles();
						roles.setId(assignRolesDTO.getPermissionsId()[i]);
						assignRoles.setRoles(roles);
						
						// set the created By
						assignRoles.setUser(loginUser);
						
						dtAssignedRolesDAO.create(assignRoles);
					}
				}
				
			}
		}catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	@Override
	public void addFacilitatorRoleWhileProjCreation(Project project){
		AssignRoles assignRoles= new AssignRoles();
		User user=new User();
		Roles roles=new Roles();
		
		user.setId(project.getUser().getId());
		roles.setId(2);
		assignRoles.setLogInUser(user);
		assignRoles.setUser(user);
		assignRoles.setRoles(roles);
		assignRoles.setProject(project);
		
		dtAssignedRolesDAO.create(assignRoles);
	}
}
