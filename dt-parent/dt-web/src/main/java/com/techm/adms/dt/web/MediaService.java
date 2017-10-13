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
import com.techm.adms.dt.dao.IDTMediaDAO;
import com.techm.adms.dt.dto.MediaDTO;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.PersonaDocument;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.PrototypeDocument;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTMediaBean;
import com.techm.adms.dt.service.IDTMediaDocumentsBean;
import com.techm.adms.dt.service.IDTPersonaDocumentBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/mediaservice")
@RequestScoped
public class MediaService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MediaService.class);

	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	IDTMediaBean dTMediaBean;
	@Inject
	IDTMediaDAO dtMediaDAO;
	@Inject
	IDTMediaDocumentsBean dtMediaDocumentsBean;
	
	@Inject
	IDTPersonaDocumentBean dTPersonaDocumentBean;

	@POST
	@Path("/createMedia/{uid}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceMessage<Media> createMedia(Media media,@PathParam("uid") final String uid) {
		ServiceMessage serviceMessage = null;
		try {
			/*User user = new User();
			user.setId(1);
			LOGGER.info("In service class");
			
			Date date = new Date();
			media.setCreatedDate(date);
			media.setUser(user);*/
			media.setUniqueId(uid);
			Media updatedMedia = dTMediaBean.createMedia(media);
			updatedMedia = dTMediaBean.getMediaDetailsByUniqueId(uid);
			LOGGER.info("In service class####"+updatedMedia);
			dtMediaDocumentsBean.upadateMediaDocument(uid, updatedMedia.getMediaId());
			dTPersonaDocumentBean.updatePersonaDocument(uid, updatedMedia.getMediaId());
			
			System.out.println("Media updated successfully::::");
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
	@Path("/getAll/{projectId}")
	@Produces({ "application/json" })
	public List<MediaDTO> getDtMediaDetails(@PathParam("projectId") int projectId) {
		List<MediaDTO> mediaDtlList = new ArrayList<MediaDTO>();
		mediaDtlList = dTMediaBean.getDTMediaDetails(projectId);
		return mediaDtlList;
	}

	@GET
	@Path("/get/{projectId}")
	@Produces({ "application/json" })
	public List<Media> readDtMediaDetails(@PathParam("projectId") int projectId) {
		List<Media> mediaList = new ArrayList<Media>();
		try {
			mediaList = dTMediaBean.getMediaDetailByProjectId(projectId);
		} catch (DTServiceException dtServiceException) {
			LOGGER.error(dtServiceException.getMessage());
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		return mediaList;
	}

	@POST
	@Path("/updateMedia")
	@Produces({ "application/json" })
	public Media updateMedia(MediaDTO modifiedMedia) {
		ServiceMessage serviceMessage = null;
		Media media = null;
		try {
			LOGGER.info("Start in updateMedia");
			media = dTMediaBean.getMediaDetailByMediaId(modifiedMedia.getMediaId());
			media.setIntervieweeName(modifiedMedia.getIntervieweeName());
			media.setTechiniqueUsed(modifiedMedia.getTechiniqueUsed());
			media.setJobType(modifiedMedia.getJobType());
			media.setInputNotes(modifiedMedia.getInputNotes());	
			
			dTMediaBean.upadateMedia(media);
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
		LOGGER.info("End in service class");
		return media;
	}

	@POST
	@Path("/deleteMedia")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void deleteMedia(int mediaId) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("Start in service class");
			dTMediaBean.deleteMedia(mediaId);
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
	@Path("/activateMedia")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public void activateMedia(int mediaId) {
		ServiceMessage serviceMessage = null;
		try {
			LOGGER.info("Start in service class");
			dTMediaBean.activateMedia(mediaId);
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
	@Path("/getActive/{projectId}")
	@Produces({"application/json"})
	public List<MediaDTO> getActiveDtMediaDetails(@PathParam("projectId") int projectId){
		List<MediaDTO> mediaDtlList = new ArrayList<MediaDTO>();
		mediaDtlList = dTMediaBean.getActiveDTMediaDetails(projectId);
		return mediaDtlList;
	}
	
	@GET
	@Path("/getPersonaDocument/{mediaId}")
	@Produces({"application/json"})
	public List<PersonaDocument> getPersonaDocument(@PathParam("mediaId") int mediaId){
		List<PersonaDocument> personaDocuments = new ArrayList<PersonaDocument>();
		try{
			personaDocuments = dTPersonaDocumentBean.retrievePersonaDocumentsByMediaId(mediaId);
			LOGGER.info("personaDocuments>>>>>"+personaDocuments);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return personaDocuments;
	}	
	
}