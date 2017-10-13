package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.PrototypeDocument;

public interface IDTPrototypeDocumentsBean {
	
	public List<PrototypeDocument> getDTPrototypeDocumentDetails() throws DTServiceException;
	public PrototypeDocument getPrototypeDocumentDetail(int prototypeDocumentId) throws DTServiceException;
	public void updatePrototypeDocument(String UID, int prototypeId) throws DTServiceException;
	public void createPrototypeDocument(PrototypeDocument prototypeDocument) throws DTServiceException;
	public List<PrototypeDocument> retrievePrototypeDocumentsByUID(String UID) throws DTServiceException;
	public List<PrototypeDocument> retrievePrototypeDocumentsByPrototypeId(int prototypeId) throws DTServiceException;
	public void deleteDocument(int prototypeDocumentId) throws DTServiceException;
}