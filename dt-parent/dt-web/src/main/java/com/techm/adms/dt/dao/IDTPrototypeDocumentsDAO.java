package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.PrototypeDocument;

public interface IDTPrototypeDocumentsDAO extends IBaseDAO<PrototypeDocument, Serializable>{

	public List<PrototypeDocument> retrievePrototypeDocumentsByUID(String UID);
	public List<PrototypeDocument> retrievePrototypeDocumentsByPrototypeId(int prototypeId);
}
