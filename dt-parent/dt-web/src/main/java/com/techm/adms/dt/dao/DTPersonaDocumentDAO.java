package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.PersonaDocument;

@Named
public class DTPersonaDocumentDAO extends BaseDAO<PersonaDocument, Serializable> implements IDTPersonaDocumentDAO {

	@Override
	public List<PersonaDocument> retrievePersonaDocumentsByUID(String UID) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PersonaDocument> query = builder.createQuery(PersonaDocument.class);
	    Root<PersonaDocument> personaDocument = query.from(PersonaDocument.class);
	    TypedQuery<PersonaDocument> typedQuery = entityManager.createQuery(query
	    		.select(personaDocument)
	            .where(builder.and(
	                    builder.equal(personaDocument.get("uniqueId"), UID)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}

	@Override
	public List<PersonaDocument> retrievePersonaDocumentsByMediaId(int mediaId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PersonaDocument> query = builder.createQuery(PersonaDocument.class);
	    Root<PersonaDocument> personaDocument = query.from(PersonaDocument.class);
	    TypedQuery<PersonaDocument> typedQuery = entityManager.createQuery(query
	    		.select(personaDocument)
	            .where(builder.and(
	                    builder.equal(personaDocument.get("mediaId"), mediaId)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
}
