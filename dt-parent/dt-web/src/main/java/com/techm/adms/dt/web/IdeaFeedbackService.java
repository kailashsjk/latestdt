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
import com.techm.adms.dt.dto.IdeaFeedbackDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.dto.PrototypeFeedbackDTO;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.IdeaCategory;
import com.techm.adms.dt.entity.IdeaFeedback;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTIdeaBean;
import com.techm.adms.dt.service.IDTIdeaCategoryBean;
import com.techm.adms.dt.service.IDTIdeaFeedbackBean;
import com.techm.adms.dt.service.IDTPrototypeFeedbackBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/ideafeedbackservice")
@RequestScoped
public class IdeaFeedbackService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaFeedbackService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	
	@Inject
	IDTIdeaFeedbackBean dTIdeaFeedbackBean;
	
	@Inject
	IDTIdeaCategoryBean dTIdeaCategoryBean;
	
	
	@Inject 
	IDTIdeaBean dTIdeaBean ;
	
	
	@Inject
	IDTEmpathyHmwQuestionsBean dtEmpathyHmwQuestionsBean;
	//-----------------------creation-------------------------------------------------------------      
    @POST
	@Path("/createIdeaFeedback")
    @Consumes({"application/json"})
    @Produces({"application/json"})
   

	public ServiceMessage<IdeaFeedback> createIdeaFeedback(IdeaFeedback ideafeedback){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class");
			/*Calendar calendar = Calendar.getInstance();
		       	Date date =  calendar.getTime();
		       	User user = new User();
				user.setId(1);
				ideafeedback.setUser(user);
				ideafeedback.setCreatedDate(date);*/
			dTIdeaFeedbackBean.captureIdeaFeedback(ideafeedback);
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
	@Path("/getAll/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetails(@PathParam("projectId") int projectId) {
		List<IdeaFeedbackDTO> ideaFeedbackList = new ArrayList<IdeaFeedbackDTO>();
		ideaFeedbackList = dTIdeaFeedbackBean.getIdeaFeedbackDetailsByProjectID(projectId);
		return ideaFeedbackList;
	}
	
	@GET
	@Path("/getActive/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetailsActive(@PathParam("projectId") int projectId) {
		List<IdeaFeedbackDTO> ideaFeedbackList = new ArrayList<IdeaFeedbackDTO>();
		ideaFeedbackList = dTIdeaFeedbackBean.getIdeaFeedbackDetailsByProjectIDActiveDatas(projectId);
		return ideaFeedbackList;
	}

	@GET
	@Path("/getAllCategory")
	@Produces({"application/json"})
	public List<IdeaCategory> getDtIdeaCategoryDetails(){
		List<IdeaCategory> ideaDtlCList = new ArrayList<IdeaCategory>();
		try{
			ideaDtlCList = dTIdeaCategoryBean.getAllDTIdeaCategoryDetails();
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return ideaDtlCList;
	}


	@Path("/deleteIdeaFeedback")
	@Produces({"application/json"})
	@Consumes({"application/json"})
	
	public void deleteIdeaFeedback(int ideaFeedbackID) {
		ServiceMessage serviceMessage = null;
		Calendar calendar = Calendar.getInstance();
	       Date date =  calendar.getTime();
	    
		try {
			LOGGER.info("Start in service class");
		
			dTIdeaFeedbackBean.deleteIdeaFeedback(ideaFeedbackID);
			
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
	
	
}
