package com.techm.adms.dt.web;

import java.util.ArrayList;
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
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.ObservationCategory;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTMediaTypeBean;
import com.techm.adms.dt.service.IDTObservationBean;
import com.techm.adms.dt.service.IDTObservationCategoryBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/observationservice")
@RequestScoped
public class ObservationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservationService.class);
	
	@Inject
	IDTObservationBean dTObservationsBean;

	@Inject
	IDTMediaTypeBean dTMediaTypeBean;
	@Inject 
	IDTObservationCategoryBean dtObservationCategoryBean;
	
	
	
	@POST
	@Path("/createObservations")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public ServiceMessage<Observation> createObservations(Observation observations) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("In service class");
			/*Date date=new Date();
			observations.setCreatedDate(date);	
			User user = new User();
			user.setId(1);			
			observations.setUser(user);
			observations.setUpdatedDate(date);*/			
			dTObservationsBean.createObservations(observations);
			
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
	@Path("/getObsCategory")
	@Produces({"application/json"})
	public List<ObservationCategory> getObservationCategories(){
		List<ObservationCategory> observationList = new ArrayList<ObservationCategory>();
		observationList = dtObservationCategoryBean.getObservationCategory();
		return observationList;
	}
	
	@GET
	@Path("/getAll/{projectId}")
	@Produces({ "application/json" })
	public List<ObservationDTO> getObservationsDetails(@PathParam("projectId") int projectId) {
		List<ObservationDTO> observationList = new ArrayList<ObservationDTO>();
		observationList = dTObservationsBean.getObservationsDetailsByProjectID(projectId);
		LOGGER.info("observationList>>>"+observationList);
		return observationList;
	}
	@GET
	@Path("/getAllObservations/{projectId}")
	@Produces({ "application/json" })
	public List<ObservationDTO> getAllObservationsDetails(@PathParam("projectId") int projectId) {
		List<ObservationDTO> observationList = new ArrayList<ObservationDTO>();
		observationList = dTObservationsBean.getAllObservationsDetailsByProjectID(projectId);
		LOGGER.info("observationList>>>"+observationList);
		return observationList;
	}

	@POST
	@Path("/updateObservations")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void updateObservation(ObservationDTO updateObservation) {
		ServiceMessage serviceMessage = null;
		try {
			Observation observation=new Observation();
			LOGGER.info("Start in service class");
			observation.setObservationID(updateObservation.getObservationID());
			observation.setObservationNotes(updateObservation.getObservationNotes());
			ObservationCategory observationCategory = new ObservationCategory();
			observationCategory.setObservationCategoryID(updateObservation.getObservationCategoryID());
			observation.setObservationCategory(observationCategory);
			dTObservationsBean.upadateObservation(observation);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}

	@POST
	@Path("/deleteObservations")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void deleteObservation(int  observationID) {
		ServiceMessage serviceMessage = null;
		try {

			LOGGER.info("Start in service class");
			dTObservationsBean.deleteObservation(observationID);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	@POST
	@Path("/activateObservations")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void activateObservations(int  observationID) {
		ServiceMessage serviceMessage = null;
		try {

			LOGGER.info("Start in service class");
			dTObservationsBean.activateObservations(observationID);
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
	
}
