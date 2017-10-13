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
import com.techm.adms.dt.dto.AssignIdeaGroupDTO;
import com.techm.adms.dt.entity.AssignIdeaGroup;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.service.IDTAssignIdeaGroupBean;
import com.techm.adms.dt.service.IDTIdeaBean;

@Path("/assignideagroupservice")
@RequestScoped
public class AssignIdeaGroupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignIdeaGroupService.class);
	@Inject 
	IDTAssignIdeaGroupBean dtAssignIdeaGroupBean ;
	@Inject
	IDTIdeaBean dtIdeaBean;
	
	@POST
	@Path("/retrieveassignideagroup")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public List<Idea> retrieveAssignIdeasByIdeaGroupId(int ideaGroupId){
		List<Idea> ideaList = new ArrayList<Idea>();
		try{
			List<AssignIdeaGroup> assignIdeaGroups = dtAssignIdeaGroupBean.retrieveAssignIdeas(ideaGroupId);
			if(assignIdeaGroups != null && assignIdeaGroups.size() > 0){
				for(AssignIdeaGroup assignIdeaGroup:assignIdeaGroups){
					ideaList.add(assignIdeaGroup.getIdea());
				}
			}
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return ideaList;
	}
	
	@GET
	@Path("/updateassignideagroup/{igid}/{ideaIds}")
    @Produces({"application/json"})
	public void updateAssignIdeasIntoIdeaGroup(@PathParam("igid") int igid, @PathParam("ideaIds") String ideaIds){
		try{
			AssignIdeaGroupDTO assignIdeaGroupDTO = new AssignIdeaGroupDTO();
			assignIdeaGroupDTO.setIdeaGroupId(igid);
			assignIdeaGroupDTO.setIdeaList(ideaIds.split(","));
			LOGGER.info("Inside updateAssignIdeasIntoIdeaGroup");
			if(assignIdeaGroupDTO != null ){
				dtAssignIdeaGroupBean.updateAssignIdeas(assignIdeaGroupDTO);
			}
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
	}
	
	@POST
	@Path("/getAllAvailableIdeas/{projectId}/{ideaGroupId}")
	@Produces({"application/json"})
	public List<Idea> retrieveAvailableIdeas(@PathParam("projectId") int projectId,@PathParam("ideaGroupId") int ideaGroupId){
		
		List<AssignIdeaGroup> assignIdeaGroups = dtAssignIdeaGroupBean.retrieveAssignIdeas(ideaGroupId);
		List<Idea> assingedIdeaList = new ArrayList<Idea>();
		if(assignIdeaGroups != null && assignIdeaGroups.size() > 0){
			for(AssignIdeaGroup assignIdeaGroup:assignIdeaGroups){
				assingedIdeaList.add(assignIdeaGroup.getIdea());
			}
		}
		LOGGER.info("assignedList::>>>"+assingedIdeaList);
		List<Idea> ideasList = dtIdeaBean.getActiveIdeasDetailsByProjectID(projectId);
		List<Idea> availableIdeasList = new ArrayList<Idea>();
		boolean existFlag = false;
		for (Idea idea : ideasList){
			existFlag = false;
			LOGGER.info("idea:::>>>"+idea);
			for(Idea idea2: assingedIdeaList){
				if (idea.getIdeaId() == idea2.getIdeaId()){
					existFlag = true;
					break;
				}
			}
			if(!existFlag){
				availableIdeasList.add(idea);
			}
		}
		LOGGER.info("availableIdeasList:::>>>"+availableIdeasList);
		return availableIdeasList;
	}
}
