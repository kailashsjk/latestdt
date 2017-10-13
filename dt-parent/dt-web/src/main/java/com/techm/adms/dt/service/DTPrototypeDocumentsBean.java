package com.techm.adms.dt.service;

import java.util.ArrayList;
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
import com.techm.adms.dt.dao.IDTPrototypeDocumentsDAO;
import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.PrototypeDocument;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTPrototypeDocumentsBean implements IDTPrototypeDocumentsBean {
private static final Logger LOGGER = LoggerFactory.getLogger(DTPrototypeDocumentsBean.class);
	
	@Inject
	IDTPrototypeDocumentsDAO dtPrototypeDocumentDAO;

	public List<PrototypeDocument> getDTPrototypeDocumentDetails() throws DTServiceException{
		return dtPrototypeDocumentDAO.readAll();
		
	   }
	
	public PrototypeDocument getPrototypeDocumentDetail(int prototypeDocumentId) throws DTServiceException {
		LOGGER.info("In Prototype Bean Class upadateProject method");
		PrototypeDocument prototypeDocuments = new PrototypeDocument();
		try{
			
			prototypeDocuments = dtPrototypeDocumentDAO.read(prototypeDocumentId);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return prototypeDocuments;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updatePrototypeDocument(String UID, int prototypeId) throws DTServiceException {
		LOGGER.info("In Prototype Bean Class upadateProject method");
		try{
			List<PrototypeDocument> prototypeDocuments = dtPrototypeDocumentDAO.retrievePrototypeDocumentsByUID(UID);
			if(prototypeDocuments != null && prototypeDocuments.size() > 0){
				for(PrototypeDocument prototypeDocument : prototypeDocuments){
					prototypeDocument.setPrototypeId(prototypeId);
					dtPrototypeDocumentDAO.update(prototypeDocument);
				}
			}

		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPrototypeDocument(PrototypeDocument prototypeDocument)
			throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtPrototypeDocumentDAO###"+ dtPrototypeDocumentDAO);
			dtPrototypeDocumentDAO.create(prototypeDocument);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}

	@Override
	public List<PrototypeDocument> retrievePrototypeDocumentsByUID(String UID) {
		return dtPrototypeDocumentDAO.retrievePrototypeDocumentsByUID(UID);
	}

	@Override
	public List<PrototypeDocument> retrievePrototypeDocumentsByPrototypeId(
			int prototypeId) {
		List<PrototypeDocument> prototypeDocuments =  new ArrayList<PrototypeDocument>();
		prototypeDocuments = dtPrototypeDocumentDAO.retrievePrototypeDocumentsByPrototypeId(prototypeId);
		LOGGER.info("prototypeDocuments###"+ prototypeDocuments);
		return prototypeDocuments;
	}

	@Override
	public void deleteDocument(int prototypeDocumentId)
			throws DTServiceException {
		PrototypeDocument prototypeDocument = dtPrototypeDocumentDAO.read(prototypeDocumentId);
		dtPrototypeDocumentDAO.delete(prototypeDocument);		
	}
}


		