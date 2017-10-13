package com.techm.adms.dt.service;

import java.io.InputStream;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.DocumentDTO;


public interface IDTUploadBean {
	
	public DocumentDTO uploadFile(InputStream inputStream, int mediaTypeId, String fileName) throws DTServiceException;
	public InputStream downloadFile(String documentId) throws DTServiceException;
	public void removeDocument(String documentId) throws DTServiceException;
}
