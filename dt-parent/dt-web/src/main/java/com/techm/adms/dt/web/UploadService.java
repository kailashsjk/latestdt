package com.techm.adms.dt.web;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.FilenameUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.DocumentDTO;
import com.techm.adms.dt.entity.MediaDocument;
import com.techm.adms.dt.entity.PersonaDocument;
import com.techm.adms.dt.entity.PrototypeDocument;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTMediaDocumentsBean;
import com.techm.adms.dt.service.IDTPersonaDocumentBean;
import com.techm.adms.dt.service.IDTPrototypeDocumentsBean;
import com.techm.adms.dt.service.IDTUploadBean;


@Path("/file")
@RequestScoped
public class UploadService {
	
	@Inject
	IDTUploadBean uploadBean;
	
	@Inject
	IDTMediaDocumentsBean dtMediaDocumentsBean;
	
	@Inject
	IDTPrototypeDocumentsBean dtPrototypeDocumentsBean;
	
	@Inject
	IDTPersonaDocumentBean dTPersonaDocumentBean;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);
	
	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/uploadMediaFile/{mediaTypeId}/{mediaId}/{UID}")
    public List<MediaDocument> uploadMedia(MultipartFormDataInput multiPartInput, @PathParam("mediaTypeId") final int mediaTypeId,@PathParam("mediaId") final int mediaId, @PathParam("UID") final String UID) {
		
		DocumentDTO documentDTO =  uploadFile(multiPartInput, mediaTypeId);
		MediaDocument mediaDocument = prepareMediaDocument(documentDTO, mediaId, UID);
		dtMediaDocumentsBean.createMediaDocument(mediaDocument);
		if(mediaId != 0){
			return dtMediaDocumentsBean.retrieveMediaDocumentsByMediaId(mediaId);
		}else{
			return dtMediaDocumentsBean.retrieveMediaDocumentsByUID(UID);
		}
	}
	
	
	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/uploadPrototypeFile/{mediaTypeId}/{prototypeId}/{UID}")
    public List<PrototypeDocument> uploadPrototype(MultipartFormDataInput multiPartInput, @PathParam("mediaTypeId") final int mediaTypeId,@PathParam("prototypeId") final int prototypeId, @PathParam("UID") final String UID) {
		DocumentDTO documentDTO =  uploadFile(multiPartInput, mediaTypeId);
		PrototypeDocument prototypeDocument = preparePrototypeDocument(documentDTO, prototypeId, UID);
		dtPrototypeDocumentsBean.createPrototypeDocument(prototypeDocument);
		if(prototypeId != 0){
			return dtPrototypeDocumentsBean.retrievePrototypeDocumentsByPrototypeId(prototypeId);
		}else{
			return dtPrototypeDocumentsBean.retrievePrototypeDocumentsByUID(UID);
		}
	}
	
	@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/uploadPersonaFile/{mediaId}/{UID}")
    public List<PersonaDocument> uploadPersonaFile(MultipartFormDataInput multiPartInput, @PathParam("mediaId") final int mediaId, @PathParam("UID") final String UID) {
		
		DocumentDTO documentDTO =  uploadFile(multiPartInput, 0);
		PersonaDocument personaDocument = preparePersonaDocument(documentDTO, mediaId, UID);
		dTPersonaDocumentBean.createPersonaDocument(personaDocument);
		if(mediaId != 0){
			return dTPersonaDocumentBean.retrievePersonaDocumentsByMediaId(mediaId);
		}else{
			return dTPersonaDocumentBean.retrievePersonaDocumentsByUID(UID);
		}
	}
	
    private DocumentDTO uploadFile(MultipartFormDataInput multiPartInput, @PathParam("mediaTypeId") final int mediaTypeId) {
		DocumentDTO documentDTO = new DocumentDTO();
        Map<String, List<InputPart>> uploadForm = multiPartInput.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file");
        InputPart inputPart = inputParts.get(0);
        try {
            String fileName = "";
            MultivaluedMap<String, String> headers = inputPart.getHeaders();
            String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
            for (String name : contentDispositionHeader) {
                if (name.trim().startsWith("filename")) {
                    String[] tmp = name.split("=");
                    fileName = FilenameUtils.getName(tmp[1]).replace("\"", "");
                }
            }
            LOGGER.info("fileName$$$$$$$"+fileName);
            InputStream inputStream = inputPart.getBody(InputStream.class, null);
            LOGGER.info("inputStream$$$$$$$"+inputStream);
            documentDTO = uploadBean.uploadFile(inputStream, mediaTypeId,fileName);
            LOGGER.info("documentId$$$$$$$"+documentDTO.getDocumentId());
		}catch(DTServiceException dtServiceException){
			LOGGER.error(dtServiceException.getMessage());
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		return documentDTO;  

	}
	
    @POST
 	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleteMediaDocument")
    public List<MediaDocument> deleteMediaDocument(MediaDocument mediaDocument){
    	uploadBean.removeDocument(mediaDocument.getDocumentID());
    	dtMediaDocumentsBean.deleteDocument(mediaDocument.getMdId());
    	return dtMediaDocumentsBean.retrieveMediaDocumentsByUID(mediaDocument.getUniqueId());
    }
    
    @POST
 	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletePrototypeDocument")
    public List<PrototypeDocument> deletePrototypeDocument( PrototypeDocument prototypeDocument){
    	uploadBean.removeDocument(prototypeDocument.getDocumentId());
    	dtPrototypeDocumentsBean.deleteDocument(prototypeDocument.getPrototypeDocumentId());
    	return dtPrototypeDocumentsBean.retrievePrototypeDocumentsByUID(prototypeDocument.getUniqueId());
    }
    
    @POST
 	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletePersonaDocument")
    public List<PersonaDocument> deletePersonaDocument( PersonaDocument personaDocument){
    	uploadBean.removeDocument(personaDocument.getDocumentId());
    	dTPersonaDocumentBean.deletePersonaDocument(personaDocument.getPersonaID());
    	return dTPersonaDocumentBean.retrievePersonaDocumentsByUID(personaDocument.getUniqueId());
    }
	/**
     * Downloads the uploaded file
     * 
     * @return Response
     * @throws Exception
     */
    @POST
    @Produces( MediaType.APPLICATION_OCTET_STREAM)
    //@Consumes(MediaType.APPLICATION_JSON)
    @Path("/downloadFile/{documentName}/{documentId}")
    public Response fileDownload(@PathParam("documentName") final String documentName, @PathParam("documentId") final String documentId) throws IOException {
        Response response = null;
        try {
        	LOGGER.info("documentId$$$$$$$"+documentId);
        	LOGGER.info("documentName$$$$$$$"+documentName);
            InputStream inputStream = uploadBean.downloadFile(documentId);
            LOGGER.info("inputStream$$$$$$$"+inputStream);
            ResponseBuilder responseBuilder = Response.ok((Object) inputStream);
            responseBuilder.header("Content-Disposition", "attachment; filename=" + documentName);
            response = responseBuilder.build();
        } catch (Exception e) {
            LOGGER.error("Unable to get download pack", e);
        } 
        return response;
    }
    
    private MediaDocument prepareMediaDocument(DocumentDTO documentDTO, int mediaId, String UID){
    	com.techm.adms.dt.entity.MediaType mediaType = new com.techm.adms.dt.entity.MediaType();
    	mediaType.setMediaTypeID(documentDTO.getMediaTypeId());
    	MediaDocument mediaDocument =  new MediaDocument();
    	mediaDocument.setDocumentID(documentDTO.getDocumentId());
    	mediaDocument.setMediaName(documentDTO.getDocumentName());
    	mediaDocument.setMediaType(mediaType);
    	mediaDocument.setUniqueId(UID);
    	if(mediaId != 0){
    		mediaDocument.setMediaId(mediaId);
    	}
    	User user = new User();
    	user.setId(1);
    	mediaDocument.setUser(user);
    	return mediaDocument;
    }
    
    private PrototypeDocument preparePrototypeDocument(DocumentDTO documentDTO, int prototypeId, String UID){
    	com.techm.adms.dt.entity.MediaType mediaType = new com.techm.adms.dt.entity.MediaType();
    	mediaType.setMediaTypeID(documentDTO.getMediaTypeId());
    	PrototypeDocument prototypeDocument =  new PrototypeDocument();
    	prototypeDocument.setDocumentId(documentDTO.getDocumentId());
    	prototypeDocument.setDocumentName(documentDTO.getDocumentName());
    	prototypeDocument.setMediaType(mediaType);
    	prototypeDocument.setUniqueId(UID);
    	if(prototypeId != 0){
    		prototypeDocument.setPrototypeId(prototypeId);
    	}
    	return prototypeDocument;
    }
    
    private PersonaDocument preparePersonaDocument(DocumentDTO documentDTO, int mediaId, String UID){
    	PersonaDocument personaDocument =  new PersonaDocument();
    	personaDocument.setDocumentId(documentDTO.getDocumentId());
    	personaDocument.setDocumentName(documentDTO.getDocumentName());
    	personaDocument.setUniqueId(UID);
    	if(mediaId != 0){
    		personaDocument.setMediaId(mediaId);
    	}
    	return personaDocument;
    }
}
