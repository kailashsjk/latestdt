package com.techm.adms.dt.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.Empathy;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.service.IDTEmpathyBean;
import com.techm.adms.dt.web.util.ServiceConstants;

@Path("/empathyservice")
@RequestScoped
public class EmpathyService {
	@Inject
	IDTEmpathyBean dTEmpathyBean;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpathyService.class);
	
	/**
	 * Retrieves Empathy list to display in empathy map screen
	 *  
	 * @param mediaId
	 * @return
	 */
	@GET
	@Path("/getempathy/{mediaID}")
	@Produces({"application/json"})
	public Empathy retrieveEmpathyList(@PathParam("mediaID") int mediaID){
		LOGGER.info("In Service Class");
		try{
		List<Observation> observationsList = dTEmpathyBean.retrieveEmpathy(mediaID);
		return prepareEmpathyMap(observationsList);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	
	/*
	 * Preparing the Empathy Map list from Observations based on Media
	 */
	private Empathy prepareEmpathyMap(List<Observation> observationsList){
		
		Empathy empathy = new Empathy();
		LOGGER.info("In Service Class");
		try{	
		for(Observation observation:observationsList){
			
			switch(observation.getObservationCategory().getObservationCategoryID()){
				case  ServiceConstants.OBSERVATION_CATEGORY_SAY_ID:
					empathy.addSayObservation(observation);
					break;
				case  ServiceConstants.OBSERVATION_CATEGORY_DO_ID:
					empathy.addDoObservation(observation);
					break;
				case  ServiceConstants.OBSERVATION_CATEGORY_FEEL_ID:
					empathy.addFeelObservation(observation);
					break;
				case  ServiceConstants.OBSERVATION_CATEGORY_THINK_ID:
					empathy.addThinkObservation(observation);
					break;
				default:
					break;
				
			}			
		}
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return empathy;
	}
	
}
