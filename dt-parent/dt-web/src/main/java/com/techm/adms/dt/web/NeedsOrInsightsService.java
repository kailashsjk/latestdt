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
import com.techm.adms.dt.dto.NeedsOrInsightsDTO;
import com.techm.adms.dt.entity.NeedsOrInsight;
import com.techm.adms.dt.service.IDTNeedsOrInsightsBean;

@Path("/needsorinsightsservice")
@RequestScoped
public class NeedsOrInsightsService {
	@Inject
	IDTNeedsOrInsightsBean dTNeedsOrInsightsBean;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NeedsOrInsightsService.class);
	
	@GET
	@Path("/getneeds/{projectID}")
	@Produces("application/json")
	public List<NeedsOrInsightsDTO> getAllNeedsListService(@PathParam("projectID") int projectID){
		List<NeedsOrInsightsDTO> needsDtlList = new ArrayList<NeedsOrInsightsDTO>();
		try{
			needsDtlList=dTNeedsOrInsightsBean.retrieveNeeds(projectID);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return needsDtlList;
	}
	
	@GET
	@Path("/getneedsbydeleteflag/{projectID}")
	@Produces("application/json")
	public List<NeedsOrInsightsDTO> getAllNeedsListServiceByDeleteFlag(@PathParam("projectID") int projectID){
		List<NeedsOrInsightsDTO> needsDtlList = new ArrayList<NeedsOrInsightsDTO>();
		try{
			needsDtlList=dTNeedsOrInsightsBean.retrieveNeedsByDeleteFlag(projectID);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return needsDtlList;
	}
	
	@GET
	@Path("/getinsights/{projectID}")
	@Produces("application/json")
	public List<NeedsOrInsightsDTO> getAllInsightsListService(@PathParam("projectID") int projectID){
		List<NeedsOrInsightsDTO> insightsDtlList = new ArrayList<NeedsOrInsightsDTO>();
		try{
			insightsDtlList=dTNeedsOrInsightsBean.retrieveInsights(projectID);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return insightsDtlList;
	}
	
	@GET
	@Path("/getinsightsbydeleteflag/{projectID}")
	@Produces("application/json")
	public List<NeedsOrInsightsDTO> getAllInsightsListServiceByDeleteFlag(@PathParam("projectID") int projectID){
		List<NeedsOrInsightsDTO> insightsDtlList = new ArrayList<NeedsOrInsightsDTO>();
		try{
			insightsDtlList=dTNeedsOrInsightsBean.retrieveInsightsByDeleteFlag(projectID);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return insightsDtlList;
	}

	//CREATE NEW NEEDS OR INSIGHTS
	@POST
	@Path("/createNeedsOrInsights")
	@Consumes({"application/json"})
	public void createNeedsOrInsightsService(NeedsOrInsight needsOrInsight){
		try{
			dTNeedsOrInsightsBean.createNeedsOrInsights(needsOrInsight);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
	}
	//DELETE NEEDS OR INSIGHTS
	@POST
	@Path("/deletenoi")
    @Consumes({"application/json"})
	public void deleteNeedsOrInsightsServ(int noiId){
		try{
			LOGGER.info("In delete part service");
			dTNeedsOrInsightsBean.deactivateNeedsOrInsights(noiId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
	}
	//EDIT NEEDS OR INSIGHTS
	@POST
	@Path("/updateNeedsOrInsights")
    @Produces({"application/json"})
	@Consumes({"application/json"})
	public NeedsOrInsight updateNeedsOrInsightsService(NeedsOrInsight needsOrInsight){
		NeedsOrInsight updatedNeedsOrInsight = new NeedsOrInsight();
		try{
			dTNeedsOrInsightsBean.upadateNeedsOrInsights(needsOrInsight);
			updatedNeedsOrInsight = dTNeedsOrInsightsBean.getDetail(needsOrInsight.getNoiId());
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return updatedNeedsOrInsight;
	}
	
	//REACTIVATE NEEDS OR INSIGHTS
	@POST
	@Path("/activatenoi")
    @Consumes({"application/json"})
	public void activateNeedsOrInsightsServ(int noiId){
		try{
			LOGGER.info("In delete part service");
			dTNeedsOrInsightsBean.reActivateNeedsOrInsights(noiId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
	}
}
