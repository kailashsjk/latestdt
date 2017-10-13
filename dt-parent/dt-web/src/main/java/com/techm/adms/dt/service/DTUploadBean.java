package com.techm.adms.dt.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.DocumentDTO;
import com.techm.adms.dt.integration.contentmanagement.IDocumentManager;



@Local
@Stateless
public class DTUploadBean implements IDTUploadBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(DTUploadBean.class);
	
	@Inject
	IDocumentManager documentManager;
	
	public DocumentDTO uploadFile(InputStream inputStream, int mediaTypeId, String fileName){
		DocumentDTO documentDTO = new DocumentDTO();
        byte[] isStreamArray = null;
        try {
            isStreamArray = IOUtils.toByteArray(inputStream);
        } catch (IOException ioExcp) {
            LOGGER.error("IOException", ioExcp);
            throw new DTServiceException("Unable to convert stream to byte array");
        }
        LOGGER.info("documentManager>>>>>"+documentManager);
        InputStream inputStreamObj = new ByteArrayInputStream(isStreamArray);
        String contentType = "application/octet-stream";//"image/jpeg";
        String documentId = documentManager.saveFile(inputStreamObj, contentType, fileName, null);
        documentDTO.setDocumentName(fileName);
        documentDTO.setMediaTypeId(mediaTypeId);
        documentDTO.setDocumentId(documentId);
        
        LOGGER.info("documentId>>>>>"+documentId);
		return documentDTO;
	}

	public InputStream downloadFile(String documentId){
		return documentManager.getFileById(documentId);
	}
	
	public void removeDocument(String documentId){
		documentManager.deleteFile(documentId);
	}
}
