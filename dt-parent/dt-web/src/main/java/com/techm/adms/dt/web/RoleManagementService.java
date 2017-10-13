package com.techm.adms.dt.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.AssignRolesDTO;
import com.techm.adms.dt.dto.ProjectDTO;
import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTRolemangementBean;

@Path("/rolemanagementservice")
@RequestScoped
public class RoleManagementService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagementService.class);
	
	@Inject
	IDTRolemangementBean dtRolemangementBean;
	
	@GET
	@Path("/getalluser")
	@Produces("application/json")
	public List<User> getAllRegisteredUser(){
		LOGGER.info("dtRolemangementServ:::>> Inside getAllRegistered Users");
		List<User> allUsers = dtRolemangementBean.getAllUser();
		return allUsers;
	}
	
	@POST
	@Path("/getuserwithrolesagnstprjctid")
	@Consumes("application/json")
	@Produces("application/json")
	public AssignRolesDTO retriveRolesAgainstProjectIdnUserId(AssignRoles assignRoles){
		LOGGER.info("dtRolemangementServ:::>>Inside retriveUserWithRolesAgainstProjectId");
		AssignRolesDTO userwithroles = dtRolemangementBean.retriveAllUserWithRoleAgainstProjectId(assignRoles.getProject().getProjectId(), assignRoles.getLogInUser().getId());
		LOGGER.info("userwithroles wrt prjId & uid:::>>>>"+userwithroles);
		return userwithroles;	
	}
	
	@POST
	@Path("getuserwithroles")
	@Consumes("application/json")
	@Produces("application/json")
	public List<AssignRolesDTO> retriveRolesAgainstProjectIdAgaintProjectId(AssignRoles assignRoles){
		LOGGER.info("dtRolemangementServ:::>>Inside retriveUserWithRolesAgainstProjectId");
		List<AssignRolesDTO> userwithroles = dtRolemangementBean.retriveAllUserWithRole(assignRoles.getProject().getProjectId());
		return userwithroles;	
	}
	
	@POST
	@Path("updateRoles/{projectId}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<AssignRolesDTO> updateRoles(List<AssignRolesDTO> assignRolesDTOs,@PathParam("projectId") int projectId){
		LOGGER.info("dtRolemangementServ:::>>Inside updateRoles");
		if(assignRolesDTOs !=null && assignRolesDTOs.size() > 0){
			dtRolemangementBean.updateRolesValues(projectId, assignRolesDTOs);
		}	
		List<AssignRolesDTO> updatedListOfRoles= dtRolemangementBean.retriveAllUserWithRole(projectId);
		return updatedListOfRoles;
	}
	
	
}
