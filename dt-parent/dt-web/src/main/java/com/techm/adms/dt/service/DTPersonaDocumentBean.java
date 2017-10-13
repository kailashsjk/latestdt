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
import com.techm.adms.dt.dao.IDTPersonaDocumentDAO;
import com.techm.adms.dt.entity.PersonaDocument;
import com.techm.adms.dt.entity.Prototype;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTPersonaDocumentBean implements IDTPersonaDocumentBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(DTPrototypeDocumentsBean.class);
	
	@Inject
	IDTPersonaDocumentDAO dtPersonaDocumentDAO;
	
	@Override
	public List<PersonaDocument> retrievePersonaDocumentsByUID(String UID)
			throws DTServiceException {
		return dtPersonaDocumentDAO.retrievePersonaDocumentsByUID(UID);
	}

	@Override
	public List<PersonaDocument> retrievePersonaDocumentsByMediaId(int mediaId)
			throws DTServiceException {
		return dtPersonaDocumentDAO.retrievePersonaDocumentsByMediaId(mediaId);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updatePersonaDocument(String UID, int mediaId) throws DTServiceException {
		LOGGER.info("In Personal Bean Class upadateProject method");
		try{
			List<PersonaDocument> personaDocuments = dtPersonaDocumentDAO.retrievePersonaDocumentsByUID(UID);
			if(personaDocuments != null && personaDocuments.size() > 0){
				for(PersonaDocument personaDocument : personaDocuments){
					personaDocument.setMediaId(mediaId);
					dtPersonaDocumentDAO.update(personaDocument);
				}
			}

		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPersonaDocument(PersonaDocument personaDocument)
			throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtPersonaDocumentDAO###"+ dtPersonaDocumentDAO);
			dtPersonaDocumentDAO.create(personaDocument);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deletePersonaDocument(int personaId) throws DTServiceException {
		LOGGER.info("In Persona Bean Class delete persona document method");
		try {
			PersonaDocument personaDocument = dtPersonaDocumentDAO.read(personaId);

			LOGGER.debug(personaDocument.toString() + "   1####  "
					+ personaDocument);
			dtPersonaDocumentDAO.delete(personaDocument);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}	
}
