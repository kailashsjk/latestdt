package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.PersonaDocument;

public interface IDTPersonaDocumentBean {
	public void updatePersonaDocument(String UID, int mediaId) throws DTServiceException;
	public void createPersonaDocument(PersonaDocument personaDocument) throws DTServiceException;
	public List<PersonaDocument> retrievePersonaDocumentsByUID(String UID) throws DTServiceException;
	public List<PersonaDocument> retrievePersonaDocumentsByMediaId(int mediaId) throws DTServiceException;
	public void deletePersonaDocument(int personaId) throws DTServiceException;
}
