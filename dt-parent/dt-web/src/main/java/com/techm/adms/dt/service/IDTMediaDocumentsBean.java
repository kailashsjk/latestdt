package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.MediaDocument;

public interface IDTMediaDocumentsBean {
	
	public List<MediaDocument> getDTMediaDocumentDetails() throws DTServiceException;
	public MediaDocument getMediaDocumentDetail(int mdId) throws DTServiceException;
	public void upadateMediaDocument(String UID, int mediaId) throws DTServiceException;
	public void createMediaDocument(MediaDocument mediaDocuments)throws DTServiceException;
	public List<MediaDocument> retrieveMediaDocumentsByUID(String UID) throws DTServiceException;
	public List<MediaDocument> retrieveMediaDocumentsByMediaId(int mediaId) throws DTServiceException;
	public void deleteDocument(int mediaDocumentId);
}