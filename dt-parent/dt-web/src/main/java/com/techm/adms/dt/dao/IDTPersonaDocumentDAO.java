package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.PersonaDocument;

public interface IDTPersonaDocumentDAO  extends IBaseDAO<PersonaDocument, Serializable>{
	public List<PersonaDocument> retrievePersonaDocumentsByUID(String UID);
	public List<PersonaDocument> retrievePersonaDocumentsByMediaId(int mediaId);
}
