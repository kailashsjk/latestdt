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
import com.techm.adms.dt.dto.IdeaDTO;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTIdeaBean;
import com.techm.adms.dt.service.IDTIdeaCategoryBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/ideaservice")
@RequestScoped
public class IdeaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTIdeaBean dTIdeaBean ;

	@Inject 
	IDTIdeaCategoryBean dTIdeaCategoryBean ;
	@Inject 
	IDTEmpathyHmwQuestionsBean dTEmpathyHmwQuestionsBean ;
	
//-----------------------creation-------------------------------------------------------------	
	@POST
	@Path("/createIdea")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public ServiceMessage<Idea> createProject(Idea idea){
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("In service class");
			/*Calendar calendar = Calendar.getInstance();
		       Date date =  calendar.getTime();
				User user = new User();
				user.setId(1);
				idea.setUser(user);
				idea.setCreatedDate(date);
				idea.setUpdatedDate(date);*/
			dTIdeaBean.createIdea(idea);
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
	

	
	
	
	//active only
	@GET
	@Path("/activeOnly/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaDTO> getIdeaDetails(@PathParam("projectId") int projectId) {
		List<IdeaDTO> ideaList = new ArrayList<IdeaDTO>();
		System.out.println("In service");
		ideaList = dTIdeaBean.getIdeasDetailsByProjectID(projectId);
		return ideaList;
	}
	

	//show all
	@GET
	@Path("/showAll/{projectId}")
	@Produces({ "application/json" })
	public List<IdeaDTO> getShowAllIdeaDetails(@PathParam("projectId") int projectId) {
		List<IdeaDTO> ideaList = new ArrayList<IdeaDTO>();
		System.out.println("In service");
		ideaList = dTIdeaBean.getAllIdeasDetailsByProjectID(projectId);
		return ideaList;
	}
	
	//delete
	@POST
	@Path("/delete")
	 @Produces({"application/json"})
		@Consumes({"application/json"})
	public ServiceMessage<Idea> deleteIdea(int ideaId){
		ServiceMessage serviceMessage = null;
		try{
			dTIdeaBean.deleteIdea(ideaId);
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
	
	//activate

		@POST
		@Path("/activate")
		 @Produces({"application/json"})
			@Consumes({"application/json"})
		public ServiceMessage<Idea> activateIdea(int ideaId){
			ServiceMessage serviceMessage = null;
			try{
				dTIdeaBean.activateIdea(ideaId);
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
		
	
	//update idea
	@POST
	@Path("/updateIdea")
	@Consumes({"application/json"})
    @Produces({"application/json"})
	
	public Idea updateIdea(Idea idea){
		Idea updatedIdea = new Idea();
		ServiceMessage serviceMessage = null;
		try{
			LOGGER.info("Start in service class");
			dTIdeaBean.updateIdea(idea);
	     		updatedIdea =dTIdeaBean.getIdeaDetail(idea.getIdeaId());
			
			LOGGER.info("End in service class");
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
		return updatedIdea;
	}
	
	
		
		
		
	
	
	@GET
	@Path("/getAllHmwQuestions/{projectId}")
	@Produces({ "application/json" })
	public List<HmwQuestionsDTO> getHmwQuestionsDetails(@PathParam("projectId") int projectId) {
		List<HmwQuestionsDTO> hmwquestionList = new ArrayList<HmwQuestionsDTO>();
		hmwquestionList = dTEmpathyHmwQuestionsBean.getDTEmpathyHmwQuestions(projectId);
		return hmwquestionList;
	}

}
