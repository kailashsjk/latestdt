package com.techm.adms.dt.web;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.ProjectDTO;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.ProjectStage;
import com.techm.adms.dt.service.IDTProjectBean;
import com.techm.adms.dt.service.IDTRolemangementBean;
import com.techm.adms.dt.service.RemoteCalculator;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/projectservice")
@RequestScoped
public class ProjectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTProjectBean dTProjectBean ;
	@Inject
	IDTRolemangementBean dtRolemangementBean;
	@POST
	@Path("/createProject")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public ServiceMessage<Project> createProject(Project project){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class-->> Create Project");
			/*User user = new User();
			user.setId(1);*/
			ProjectStage projectStage = new ProjectStage();
			projectStage.setProjectStageID(1);
			project.setProjectStatus(1);
			project.setProjectStage(projectStage);
			//project.setUser(user);
			dTProjectBean.createProject(project);
			Project newProject= dTProjectBean.getProjectBasedOnProjId(project.getProjId());
			LOGGER.info("In service class");
			LOGGER.info("Project updated successfully::::");
			dtRolemangementBean.addFacilitatorRoleWhileProjCreation(newProject); 
			LOGGER.info("Facilitator Role Given");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return serviceMessage;
	}
	
	@GET
	@Path("/getAll/{userId}")
	@Produces({"application/json"})
	public List<ProjectDTO> getDtProjectDetails(@PathParam("userId") int userId){
		List<ProjectDTO> projectDtlList = new ArrayList<ProjectDTO>();
		try{
			projectDtlList = dTProjectBean.getAllDTProjectDetails(userId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return projectDtlList;
	}
	
	@GET
	@Path("/getActive/{userId}")
	@Produces({"application/json"})
	public List<ProjectDTO> getActiveDtProjectDetails(@PathParam("userId") int userId){
		List<ProjectDTO> projectDtlList = new ArrayList<ProjectDTO>();
		try{
			projectDtlList = dTProjectBean.getActiveDTProjectDetails(userId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return projectDtlList;
	}
	
	@GET
	@Path("/get/{projectId}")
	@Produces({"application/json"})
	public Project readDtProjectDetails(@PathParam("projectId") int projectId){
		Project project = new Project();
		try{
			project = dTProjectBean.getProjectDetail(projectId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return project;
	}
	
	@POST
	@Path("/updateProject")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public Project updateProject(Project project){
		Project updatedProject = new Project();
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("Start in service class");
			dTProjectBean.upadateProject(project);
			updatedProject = dTProjectBean.getProjectDetail(project.getProjectId());
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return updatedProject;
	}
	
	@POST
	@Path("/delete")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public ServiceMessage<Project> deleteProject(int projectId){
		ServiceMessage serviceMessage = null;
		try{
			dTProjectBean.deleteProject(projectId);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return serviceMessage;
	}
	
	@POST
	@Path("/updateProjectStage")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public Project updateProjectStage(Project project){
		Project updatedProject = new Project();
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("Start in service class updateProjectStage");
			dTProjectBean.upadateProjectStage(project);
			updatedProject = dTProjectBean.getProjectDetail(project.getProjectId());
			LOGGER.info("End in service class updateProjectStage");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return updatedProject;
	}
	
	@GET
	@Path("/getProjectStages")
	@Produces({"application/json"})
	public List<ProjectStage> getProjectStages(){
		List<ProjectStage> projectStages = new ArrayList<ProjectStage>();
		try{
			projectStages = dTProjectBean.getProjectStages();
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return projectStages;
	}
	
	
	@GET
	@Path("/invokeejb")
	//@Produces({"application/json"})
	public void invokeEJB(){
		try {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
			final Context context = new InitialContext(jndiProperties);
			final RemoteCalculator statelessRemoteCalculator =(RemoteCalculator) context.lookup("java:global/dt-web/CalculatorBean!"
		            + RemoteCalculator.class.getName());
			System.out.println("Obtained a remote stateless calculator for invocation");
	        // invoke on the remote calculator
	        int a = 204;
	        int b = 340;
	        System.out.println("Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
	        int sum = statelessRemoteCalculator.add(a, b);
	        System.out.println("Remote calculator returned sum = " + sum);
	        if (sum != a + b) {
	            throw new RuntimeException("Remote stateless calculator returned an incorrect sum " + sum + " ,expected sum was "
	                + (a + b));
	        }
	        // try one more invocation, this time for subtraction
	        int num1 = 3434;
	        int num2 = 2332;
	        System.out.println("Subtracting " + num2 + " from " + num1
	            + " via the remote stateless calculator deployed on the server");
	        int difference = statelessRemoteCalculator.subtract(num1, num2);
	        System.out.println("Remote calculator returned difference = " + difference);
	        if (difference != num1 - num2) {
	            throw new RuntimeException("Remote stateless calculator returned an incorrect difference " + difference
	                + " ,expected difference was " + (num1 - num2));
	        }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
