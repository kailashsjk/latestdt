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
import com.techm.adms.dt.dto.AssignHMWDTO;
import com.techm.adms.dt.entity.AssignHMW;
import com.techm.adms.dt.entity.AssignIdeaGroup;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.service.IDTAssignHMWBean;
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
@Path("/assignhmwservice")
@RequestScoped
public class AssignHMWService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignHMWService.class);
	@Inject 
	IDTAssignHMWBean dtAssignHMWBean;
	@Inject
	IDTEmpathyHmwQuestionsBean dtEmpathyHmwQuestionsBean;
	
	@POST
	@Path("/getassignedhmw")
	@Produces("application/json")
	@Consumes("application/json")
	public List<HmwQuestion> retrieveAssignedHMWByIdeaGroupId(int ideaGroupId){
		List<HmwQuestion> hmwQuestionList = new ArrayList<HmwQuestion>();
		try{
			List<AssignHMW> assignHmwQuestions = dtAssignHMWBean.retrieveHMW(ideaGroupId);
			if(assignHmwQuestions != null && assignHmwQuestions.size() > 0){
				for(AssignHMW assignHmw:assignHmwQuestions){
					hmwQuestionList.add(assignHmw.getHmwQuestion());
				}
			}
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return hmwQuestionList;
	}
	@GET
	@Path("/updatehmwgroup/{igid}/{questionID}")
    @Produces({"application/json"})
	public void updateAssignIdeasIntoIdeaGroup(@PathParam("igid") int igid, @PathParam("questionID") String questionID){
		try{
			AssignHMWDTO assignHMWDTO = new AssignHMWDTO();
			assignHMWDTO.setIdeaGroupId(igid);
			assignHMWDTO.setHmwList(questionID.split(","));
			LOGGER.info("Inside updateAssignHMWs");
			if(assignHMWDTO != null ){
				dtAssignHMWBean.updateAssignHMW(assignHMWDTO);
			}
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
	}
	@POST
	@Path("/getallavailablehmws/{projectId}/{ideaGroupId}")
	@Produces({"application/json"})
	public List<HmwQuestion> retrieveAvailableHMWs(@PathParam("projectId") int projectId,@PathParam("ideaGroupId") int ideaGroupId){
		
		List<HmwQuestion> hmwQuestionList = new ArrayList<HmwQuestion>();
		List<AssignHMW> assignHmwQuestions = dtAssignHMWBean.retrieveHMW(ideaGroupId);
		if(assignHmwQuestions != null && assignHmwQuestions.size() > 0){
			for(AssignHMW assignHmw:assignHmwQuestions){
				hmwQuestionList.add(assignHmw.getHmwQuestion());		//List containing all assigned HMWs
			}
		}
		LOGGER.info("assignedHMWQuestionsList::>>>"+hmwQuestionList);
		List<HmwQuestion> hmwsList = dtEmpathyHmwQuestionsBean.getActiveDTEmpathyHmwQuestionsEntity(projectId); //All Available Ideas Based On ProjectId
		List<HmwQuestion> availableIdeasList = new ArrayList<HmwQuestion>();
		boolean existFlag = false;
		for (HmwQuestion hmwQuestion : hmwsList){
			existFlag = false;
			LOGGER.info("hmwQuestion:::>>>"+hmwQuestion);
			for(HmwQuestion hmwQuestion2: hmwQuestionList){
				if (hmwQuestion.getQuestionID() == hmwQuestion2.getQuestionID()){
					existFlag = true;
					break;
				}
			}
			if(!existFlag){
				availableIdeasList.add(hmwQuestion);
			}
		}
		LOGGER.info("availableIdeasList:::>>>"+availableIdeasList);
		return availableIdeasList;
	}
}
