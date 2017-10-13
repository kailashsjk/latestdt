package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.MediaDocument;

public interface IDTMediaDocumentsDAO extends IBaseDAO<MediaDocument, Serializable>{

	public List<MediaDocument> retrieveMediaDocumentsByUID(String UID);
	public List<MediaDocument> retrieveMediaDocumentsByMediaId(int mediaId);
}
