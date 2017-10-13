package com.techm.adms.dt.web;

import java.util.ArrayList;
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
import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.entity.MediaDocument;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.PrototypeDocument;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTIdeaGroupBean;
import com.techm.adms.dt.service.IDTProjectBean;
import com.techm.adms.dt.service.IDTPrototypeBean;
import com.techm.adms.dt.service.IDTPrototypeDocumentsBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/prototypeservice")
@RequestScoped
public class PrototypeService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PrototypeService.class);
	
	@Inject 
	IDTPrototypeBean dTPrototypeBean ;
	
	@Inject
	IDTEmpathyHmwQuestionsBean dtEmpathyHmwQuestionsBean;
	
	@Inject 
	IDTIdeaGroupBean dtIdeaGroupBean;
	
	@Inject
	IDTPrototypeDocumentsBean dtPrototypeDocumentsBean;

		
	@POST
	@Path("/createPrototype/{uid}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public ServiceMessage<Prototype> createPrototype(Prototype prototype,@PathParam("uid") final String uid) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("In service class");
			prototype.setUniqueId(uid);
			dTPrototypeBean.createPrototype(prototype);
			Prototype updatedPrototype = dTPrototypeBean.getPrototypeDetailsByUniqueId(uid);
			LOGGER.info("updatedPrototype>>>>>>>"+updatedPrototype);
			dtPrototypeDocumentsBean.updatePrototypeDocument(uid, updatedPrototype.getPrototypeId());
			
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return serviceMessage;
	}		
	
		
	@GET
	@Path("/get/{projectId}")
	@Produces({"application/json"})
	public List<PrototypeDTO> getPrototypeDetails(@PathParam("projectId") int projectId){
		List<PrototypeDTO> prototypelList = new ArrayList<PrototypeDTO>();
		prototypelList = dTPrototypeBean.getPrototypeDetailByProjectId(projectId);
		
		return prototypelList;
	}
	
	@GET
	@Path("/getAll/{projectId}")
	@Produces({"application/json"})
	public List<PrototypeDTO> getDTPrototypeDetails(@PathParam("projectId") int projectId){
		List<PrototypeDTO> prototypelList = new ArrayList<PrototypeDTO>();
		prototypelList = dTPrototypeBean.getDTPrototypeDetailByProjectId(projectId);
		
		return prototypelList;
	}
			
	@GET
	@Path("/getActive/{projectId}")
	@Produces({"application/json"})
	public List<PrototypeDTO> getActiveDTPrototypeDetails(@PathParam("projectId") int projectId){
		List<PrototypeDTO> prototypelList = new ArrayList<PrototypeDTO>();
		prototypelList = dTPrototypeBean.getPrototypeDetailByProjectId(projectId);
		
		return prototypelList;
	}
			
	@POST
	@Path("/updatePrototypeDescription")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public void updatePrototypeDescription(Prototype prototype){
		ServiceMessage serviceMessage = null;
		LOGGER.info("inside create "+prototype.getPrototypeId());
		//LOGGER.info("inside create "+prototype.getIdeaGroup().getIGID());
		LOGGER.info("inside create "+prototype.getPrototypeDescription());
		try{
			
			LOGGER.info("Start in service class");
			dTPrototypeBean.upadatePrototypeDescription(prototype);
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
	@Path("/updatePrototypeStatus/{prototypeId}/{prototypeStatus}")
    @Produces({"application/json"})
	public void updatePrototypeStatus(@PathParam("prototypeId") int prototypeId,@PathParam("prototypeStatus") String prototypeStatus){
		ServiceMessage serviceMessage = null;
		try{
			
			LOGGER.info("Start in service class");
			Prototype prototype = new Prototype();
			prototype.setPrototypeId(prototypeId);
			prototype.setPrototypeStatus(prototypeStatus);
			dTPrototypeBean.upadatePrototypeStatus(prototype);
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
			dTPrototypeBean.deletePrototype(prototypeId);
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
	@Path("/ActivatePrototype")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public void ActivatePrototype(int prototypeId){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("Start in service class");
			LOGGER.info("prototype id "+prototypeId);
			dTPrototypeBean.activatePrototype(prototypeId);
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
	@Path("/getIdeaGroup/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaGroupDTO> getIdeaGroupDetails(@PathParam("projectId") int projectId) {
		List<IdeaGroupDTO> ideagroupList = new ArrayList<IdeaGroupDTO>();
		ideagroupList = dtIdeaGroupBean.getIdeaGroupDetailsByProjectID(projectId);
		LOGGER.info("observationList>>>"+ideagroupList);
		return ideagroupList;
	}
	
	@POST
	@Path("/setTest")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public void updateTest(Prototype prototype){
		ServiceMessage serviceMessage = null;
		LOGGER.info("inside create "+prototype.getPrototypeId());
		//LOGGER.info("inside create "+prototype.getIdeaGroup().getIGID());
		//LOGGER.info("inside create "+prototype.getPrototypeDescription());
		try{
			
			LOGGER.info("Start in service class");
			dTPrototypeBean.upadateTest(prototype);
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
	@Path("/getPrototypeDocuments/{prototypeId}")
	@Produces({"application/json"})
	public List<PrototypeDocument> getPrototypeDocuments(@PathParam("prototypeId") int prototypeId){
		List<PrototypeDocument> prototypeDocuments = new ArrayList<PrototypeDocument>();
		try{
			prototypeDocuments = dtPrototypeDocumentsBean.retrievePrototypeDocumentsByPrototypeId(prototypeId);
			LOGGER.info("prototypeDocuments>>>>>"+prototypeDocuments);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return prototypeDocuments;
	}	
	
}
 