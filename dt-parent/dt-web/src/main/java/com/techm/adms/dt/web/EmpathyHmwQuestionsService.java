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
import com.techm.adms.dt.dto.HmwQuestionsDTO;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTMediaBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;
@RequestScoped
@Path("/empathyservice")


public class EmpathyHmwQuestionsService {
private static final Logger LOGGER = LoggerFactory.getLogger(EmpathyHmwQuestionsService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTEmpathyHmwQuestionsBean dTEmpathyHmwQuestionsBean ;
	
	@Inject 
	IDTMediaBean dTMediaBean ;

	//Insert HMW Questions
	@POST
	@Path("/createHmwQuestions")
	@Consumes({"application/json"})
    @Produces({"application/json"})
	public ServiceMessage<HmwQuestion> createHmwQuestions(
			HmwQuestion hmwQuestions) {
		ServiceMessage serviceMessage = null;
		try {

			LOGGER.info("In service class");
			dTEmpathyHmwQuestionsBean.createHmwQuestions(hmwQuestions);
			LOGGER.info("In service class");
			System.out.println("family updated successfully::::");
			serviceMessage = ServiceMessageHandler
					.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return serviceMessage;
	}

	
	@GET
	@Path("/getHmwQuestion/{projectId}")
	@Produces({"application/json"})
	public List<HmwQuestionsDTO> readHmwQuestions(@PathParam("projectId") int projectId){
		List<HmwQuestionsDTO> empathyHMWDtlList = new ArrayList<HmwQuestionsDTO>();
		//HmwQuestion hmwQuestions= new HmwQuestion();
		try{
			empathyHMWDtlList = dTEmpathyHmwQuestionsBean.getDTEmpathyHmwQuestions(projectId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return empathyHMWDtlList;
	}
	

	@GET
	@Path("/getActiveHmwQuestion/{projectId}")
	@Produces({"application/json"})
	public List<HmwQuestionsDTO> readActiveHmwQuestions(@PathParam("projectId") int projectId){
		List<HmwQuestionsDTO> empathyHMWDtlList = new ArrayList<HmwQuestionsDTO>();
		try{
			empathyHMWDtlList = dTEmpathyHmwQuestionsBean.getActiveDTEmpathyHmwQuestions(projectId); 
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return empathyHMWDtlList;
	}
	
	
	//Edit HMW Questions 
	
	@POST
	@Path("/updateHmwQuestions")
	@Consumes({"application/json"})
    @Produces({"application/json"})
	public HmwQuestion updateHmwQuestions(HmwQuestion hmwQuestion){
		ServiceMessage serviceMessage = null;
		HmwQuestion hmwQuestions = new HmwQuestion();
		try{
			LOGGER.info("Start in service class"+hmwQuestion.toString());
			dTEmpathyHmwQuestionsBean.updateDTEmpathyHmwQuestions(hmwQuestion);
			hmwQuestions = dTEmpathyHmwQuestionsBean.getHmwQuestionsDetailsByQuestionId(hmwQuestion.getQuestionID());
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return hmwQuestions;
	}
	
	@POST
	@Path("/deleteHmwQuestion")
	@Consumes({"text/plain"})
	//@Produces({ "application/json" })
	//@Consumes({ "application/json" })
	public void deleteHmwQuestion(int questionID) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("Start in service class");
			dTEmpathyHmwQuestionsBean.deleteHmwQuestion(questionID);
			serviceMessage = ServiceMessageHandler
					.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	@POST
	@Path("/activateHmwQuestion")
	@Consumes({"text/plain"})
	//@Produces({ "application/json" })
	//@Consumes({ "application/json" })
	public void activateHmwQuestion(int questionID) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("Start in service class");
			dTEmpathyHmwQuestionsBean.activateHmwQuestion(questionID);
			serviceMessage = ServiceMessageHandler
					.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(
					ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	@GET
	@Path("/getAllMediaName/{projectId}")
	@Produces({"application/json"})
	public List<Media> getMediaIdFromMedia(@PathParam("projectId") int projectId){
		List<Media> mediaDtlList = new ArrayList<Media>();
		try{
			mediaDtlList = dTMediaBean.getMediaDetailByProjectId(projectId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return mediaDtlList;
	}

}


