package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.MediaDocument;


@Named
public class DTMediaDocumentsDAO extends BaseDAO<MediaDocument, Serializable> implements IDTMediaDocumentsDAO {

	@Override
	public List<MediaDocument> retrieveMediaDocumentsByUID(String UID) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<MediaDocument> query = builder.createQuery(MediaDocument.class);
	    Root<MediaDocument> mediaDocument = query.from(MediaDocument.class);
	    TypedQuery<MediaDocument> typedQuery = entityManager.createQuery(query
	    		.select(mediaDocument)
	            .where(builder.and(
	                    builder.equal(mediaDocument.get("uniqueId"), UID)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}

	@Override
	public List<MediaDocument> retrieveMediaDocumentsByMediaId(int mediaId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<MediaDocument> query = builder.createQuery(MediaDocument.class);
	    Root<MediaDocument> mediaDocument = query.from(MediaDocument.class);
	    TypedQuery<MediaDocument> typedQuery = entityManager.createQuery(query
	    		.select(mediaDocument)
	            .where(builder.and(
	                    builder.equal(mediaDocument.get("mediaId"), mediaId)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}

}
