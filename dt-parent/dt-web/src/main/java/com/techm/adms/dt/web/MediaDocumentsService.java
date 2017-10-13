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
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.MediaDocument;
import com.techm.adms.dt.entity.MediaType;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.service.IDTMediaBean;
import com.techm.adms.dt.service.IDTMediaDocumentsBean;
import com.techm.adms.dt.service.IDTProjectBean;
import com.techm.adms.dt.web.util.ServiceConstants;
import com.techm.adms.dt.web.util.ServiceMessage;
import com.techm.adms.dt.web.util.ServiceMessageHandler;

@Path("/mediadocumentsservice")
@RequestScoped
public class MediaDocumentsService {

private static final Logger LOGGER = LoggerFactory.getLogger(MediaDocumentsService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTMediaDocumentsBean dTMediaDocumentBean ;
	
	@POST
	@Path("/createMediaDocuments")
    @Consumes({"application/json"})
	public ServiceMessage<MediaDocument> createMediaDocuments(MediaDocument mediaDocuments){
		ServiceMessage serviceMessage = null;
		try{
		LOGGER.info("In service class");
		dTMediaDocumentBean.createMediaDocument(mediaDocuments);		
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
	@Path("/getAll")
	@Produces({"application/json"})
	public List<MediaDocument> getDtMediaDocumentsDetails(){
		List<MediaDocument> mediaDocumentDtlList = new ArrayList<MediaDocument>();
		try{
			mediaDocumentDtlList = dTMediaDocumentBean.getDTMediaDocumentDetails();
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return mediaDocumentDtlList;
	}
	
	@GET
	@Path("/get/{mdId}")
	@Produces({"application/json"})
	public MediaDocument readDtMediaDocumentDetails(@PathParam("mdId") int mdId){
		MediaDocument mediaDocuments = new MediaDocument();
		try{
			mediaDocuments = dTMediaDocumentBean.getMediaDocumentDetail(mdId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return mediaDocuments;
	}
	
	@GET
	@Path("/getMediaDocuments/{mediaId}")
	@Produces({"application/json"})
	public List<MediaDocument> readMediaDocuments(@PathParam("mediaId") int mediaId){
		List<MediaDocument> mediaDocuments = new ArrayList<MediaDocument>();
		try{
			mediaDocuments = dTMediaDocumentBean.retrieveMediaDocumentsByMediaId(mediaId);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return mediaDocuments;
	}	
	@POST
	@Path("/updateMedia")
    @Consumes({"application/json"})
	public void updateMediaDocument(MediaDocument mediaDocuments){
		ServiceMessage serviceMessage = null;
		try{
			
			LOGGER.info("Start in service class");
			//dTMediaDocumentBean.upadateMediaDocument(mediaDocuments);
			LOGGER.info("End in service class");
			mediaDocuments=dTMediaDocumentBean.getMediaDocumentDetail(mediaDocuments.getMdId());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_SUCCESS);
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, dtServiceException);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
			serviceMessage = ServiceMessageHandler.prepareMessage(ServiceConstants.PROJECT_SAVE_ERROR, exception);
		}
	}
	
}
