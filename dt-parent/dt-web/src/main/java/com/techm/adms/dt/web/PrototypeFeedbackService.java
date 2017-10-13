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
import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.dto.PrototypeFeedbackDTO;
import com.techm.adms.dt.entity.PrototypeFeedback;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTPrototypeBean;
import com.techm.adms.dt.service.IDTPrototypeFeedbackBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/prototypeFeedback")
@RequestScoped
public class PrototypeFeedbackService {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(PrototypeFeedbackService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	
		
	@Inject 
	IDTPrototypeFeedbackBean dTPrototypeFeedbackBean;

	@Inject 
	IDTPrototypeBean dTPrototypeBean ;
	
	@POST
	@Path("/createPrototypeFeedback")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public ServiceMessage<PrototypeFeedback> createPrototypeFeedback(PrototypeFeedback prototypeFeedback){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class");
			dTPrototypeFeedbackBean.createPrototypeFeedback(prototypeFeedback);			
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
	@Path("/getActive/{projectId}")
	@Produces({ "application/json" })
	public List<PrototypeFeedbackDTO> getAllPrototypeFeedbackDetails(@PathParam("projectId") int projectId) {
		List<PrototypeFeedbackDTO> prototypeFeedbackList = new ArrayList<PrototypeFeedbackDTO>();
		prototypeFeedbackList = dTPrototypeFeedbackBean.getPrototypeFeedbackAndPrototype(projectId);
		return prototypeFeedbackList;
	}
	
	

	
	
}
