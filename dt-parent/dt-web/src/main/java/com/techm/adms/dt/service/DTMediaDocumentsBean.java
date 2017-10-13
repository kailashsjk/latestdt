package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dao.IDTMediaDocumentsDAO;
import com.techm.adms.dt.entity.MediaDocument;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTMediaDocumentsBean implements IDTMediaDocumentsBean {
private static final Logger LOGGER = LoggerFactory.getLogger(DTMediaDocumentsBean.class);
	
	@Inject
	IDTMediaDocumentsDAO dtMediaDocumentDAO;

	public List<MediaDocument> getDTMediaDocumentDetails() throws DTServiceException{
		return dtMediaDocumentDAO.readAll();
		
	   }
	@Override
	public MediaDocument getMediaDocumentDetail(int mdId) throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		MediaDocument mediaDocuments = new MediaDocument();
		try{
			mediaDocuments = dtMediaDocumentDAO.read(mdId);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return mediaDocuments;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateMediaDocument(String UID, int mediaId) throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateMediaDocument method##"+mediaId);
		try{
			List<MediaDocument> mediaDocuments = dtMediaDocumentDAO.retrieveMediaDocumentsByUID(UID);
			if(mediaDocuments != null && mediaDocuments.size() > 0){
				for(MediaDocument mediaDocument : mediaDocuments){
					mediaDocument.setMediaId(mediaId);
					dtMediaDocumentDAO.update(mediaDocument);
				}
			}
			
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createMediaDocument(MediaDocument mediaDocuments)
			throws DTServiceException {
		try{
			LOGGER.info("In Bean Class dtMediaDocumentDAO###"+ dtMediaDocumentDAO);
			dtMediaDocumentDAO.create(mediaDocuments);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	
	@Override
	public List<MediaDocument> retrieveMediaDocumentsByUID(String UID)
			throws DTServiceException {
		return dtMediaDocumentDAO.retrieveMediaDocumentsByUID(UID);
	}
	
	@Override
	public List<MediaDocument> retrieveMediaDocumentsByMediaId(int mediaId)
			throws DTServiceException {
		return dtMediaDocumentDAO.retrieveMediaDocumentsByMediaId(mediaId);
	}
	
	@Override
	public void deleteDocument(int mediaDocumentId) {
		MediaDocument mediaDocument =  dtMediaDocumentDAO.read(mediaDocumentId);
		dtMediaDocumentDAO.delete(mediaDocument);
	}
	
}


		