package com.techm.adms.dt.web;

import java.util.ArrayList;
import java.util.Date;
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

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.IdeaGroupDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.IdeaGroup;


import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.ObservationCategory;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.DTIdeaGroupBean;
import com.techm.adms.dt.service.IDTIdeaGroupBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/ideagroupservice")
@RequestScoped

public class IdeaGroupService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTIdeaGroupBean dtIdeaGroupBean ;
	
	
	@POST
	@Path("/createIdeaGroup")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public ServiceMessage<IdeaGroup> createIdeaGroup(IdeaGroup ideaGroup){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class");
			/*Date date=new Date();
			ideaGroup.setCreateDate(date);	
			User user = new User();
			user.setId(1);			
			ideaGroup.setUser(user);
			ideaGroup.setUpdatedDate(date);*/
			dtIdeaGroupBean.createIdeaGroup(ideaGroup);
			LOGGER.info("In service class");
			System.out.println("IdeaGroup created successfully::::");
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
	@Path("/getIdeaGroup/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaGroupDTO> getIdeaGroupDetails(@PathParam("projectId") int projectId) {
		List<IdeaGroupDTO> ideagroupList = new ArrayList<IdeaGroupDTO>();
		ideagroupList = dtIdeaGroupBean.getIdeaGroupDetailsByProjectID(projectId);
		LOGGER.info("observationList>>>"+ideagroupList);
		return ideagroupList;
	}
	
	

	@GET
	@Path("/getAllIdeaGroup/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaGroupDTO> getAllIdeaGroupDetails(@PathParam("projectId") int projectId) {
		List<IdeaGroupDTO> ideagroupList = new ArrayList<IdeaGroupDTO>();
		ideagroupList = dtIdeaGroupBean.getAllIdeaGroupDetailsByProjectID(projectId);
		LOGGER.info("observationList>>>"+ideagroupList);
		return ideagroupList;
	}
	
	

	@POST
	@Path("/updateIdeaGroup")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void updateIdeaGroup(IdeaGroupDTO updateIdeaGroup) {
		ServiceMessage serviceMessage = null;
		try {
			IdeaGroup ideagroup=new IdeaGroup();
			LOGGER.info("Start in service class");
			ideagroup.setIGID(updateIdeaGroup.getIGID());
			ideagroup.setIGName(updateIdeaGroup.getIGName());
			dtIdeaGroupBean.updateIdeaGroup(ideagroup);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	@POST
	@Path("/deleteIdeaGroup")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void deleteIdeaGroup(int IGID) {
		ServiceMessage serviceMessage = null;
		try {

			LOGGER.info("Start in service class");
			dtIdeaGroupBean.deleteIdeaGroup(IGID);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}


@POST
@Path("/activateIdeaGroup")
@Produces({ "application/json" })
@Consumes({ "application/json" })
public void activateIdeaGroup(int IGID) {
	ServiceMessage serviceMessage = null;
	try {

		LOGGER.info("Start in service class");
		dtIdeaGroupBean.activateIdeaGroup(IGID);
		serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
	} catch (DTServiceException dtServiceException) {
		LOGGER.error(dtServiceException.getMessage());
		serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
	} catch (Exception exception) {
		LOGGER.error(exception.getMessage());
		serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
	}
}
}
