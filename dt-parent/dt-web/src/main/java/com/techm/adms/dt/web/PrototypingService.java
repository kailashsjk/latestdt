package com.techm.adms.dt.web;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.techm.adms.dt.dto.PrototypingDTO;
import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTIdeaBean;
import com.techm.adms.dt.service.IDTPrototypingBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/prototypeservice")
@RequestScoped
public class PrototypingService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PrototypingService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTPrototypingBean dTPrototypingBean ;
	@Inject
	IDTEmpathyHmwQuestionsBean dtEmpathyHmwQuestionsBean;
	@Inject 
	IDTIdeaBean dTIdeaBean ;
	
	
	@POST
	@Path("/createPrototype")
    @Produces({"application/json"})
	public ServiceMessage<Prototype> createPrototype(Prototype prototyping){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class");
			Calendar calendar = Calendar.getInstance();
		    Date date =  calendar.getTime();
			User user=new User();
			user.setId(1);
			prototyping.setCreatedDate(date);
			prototyping.setUser(user);
			dTPrototypingBean.createPrototype(prototyping);
			LOGGER.info("In service class");
			System.out.println("family updated successfully::::");
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
	@Path("/get/{projectId}")
	@Produces({"application/json"})
	public List<PrototypingDTO> getPrototypeDetails(@PathParam("projectId") int projectId){
		List<PrototypingDTO> prototypelList = new ArrayList<PrototypingDTO>();
		prototypelList = dTPrototypingBean.getPrototypeDetailByProjectId(projectId);
		
		return prototypelList;
	}
			
	@POST
	@Path("/updatePrototypeDescription")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public void updatePrototypeDescription(Prototype prototyping){
		ServiceMessage serviceMessage = null;
		try{
			
			LOGGER.info("Start in service class");
			dTPrototypingBean.upadatePrototypeDescription(prototyping);
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	@GET
	@Path("/updatePrototypeStatus/{prototypeId}/{prototypeStatus}")
    @Produces({"application/json"})
	public void updatePrototypeStatus(@PathParam("prototypeId") int prototypeId,@PathParam("prototypeStatus") String prototypeStatus){
		ServiceMessage serviceMessage = null;
		try{
			
			LOGGER.info("Start in service class");
			Prototype prototyping = new Prototype();
			prototyping.setPrototypeId(prototypeId);
			prototyping.setPrototypeStatus(prototypeStatus);
			
			dTPrototypingBean.upadatePrototypeStatus(prototyping);
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
		
	
	@POST
	@Path("/deletePrototype")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public void deletePrototype(int prototypeId){
		ServiceMessage serviceMessage = null;
		try{
			
			LOGGER.info("Start in service class");
		
			
			dTPrototypingBean.deletePrototype(prototypeId);
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	
}
 