package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.PrototypeDocument;


@Named
public class DTPrototypeDocumentsDAO extends BaseDAO<PrototypeDocument, Serializable> implements IDTPrototypeDocumentsDAO {

	@Override
	public List<PrototypeDocument> retrievePrototypeDocumentsByUID(String UID) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PrototypeDocument> query = builder.createQuery(PrototypeDocument.class);
	    Root<PrototypeDocument> prototypeDocument = query.from(PrototypeDocument.class);
	    TypedQuery<PrototypeDocument> typedQuery = entityManager.createQuery(query
	    		.select(prototypeDocument)
	            .where(builder.and(
	                    builder.equal(prototypeDocument.get("uniqueId"), UID)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}

	@Override
	public List<PrototypeDocument> retrievePrototypeDocumentsByPrototypeId(int prototypeId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<PrototypeDocument> query = builder.createQuery(PrototypeDocument.class);
	    Root<PrototypeDocument> prototypeDocument = query.from(PrototypeDocument.class);
	    TypedQuery<PrototypeDocument> typedQuery = entityManager.createQuery(query
	    		.select(prototypeDocument)
	            .where(builder.and(
	                    builder.equal(prototypeDocument.get("prototypeId"), prototypeId)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}

}
