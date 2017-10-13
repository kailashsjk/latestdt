package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;




import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.MediaDocument;
import com.techm.adms.dt.entity.MediaType;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Named
public class DTMediaDAO extends BaseDAO<Media, Serializable> implements IDTMediaDAO {

	@Override
	public List<Media> getMediaDetailsByProjectId(int projectId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root media = criteriaQuery.from(Media.class);
        criteriaQuery.multiselect(media);
        CriteriaQuery result = criteriaQuery.where(criteriaBuilder.equal(media.get("project"),projectId));
        TypedQuery query = entityManager.createQuery(result);
        return query.getResultList();
	}

	@Override
	public Media getMediaDetailsByUniqueId(String uniqueId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root media = criteriaQuery.from(Media.class);
        criteriaQuery.multiselect(media);
        CriteriaQuery result = criteriaQuery.where(criteriaBuilder.equal(media.get("uniqueId"),uniqueId));
        TypedQuery query = entityManager.createQuery(result);
        return (Media) query.getSingleResult();
	}
 
	@Override
	public void deleteMedia(int mediaId) {
		Media media = read(mediaId);
		media.setDeleteFlag(1);
	}
	@Override
	public void activateMedia(int mediaId) {
		Media media = read(mediaId);
		media.setDeleteFlag(0);
	}


	@Override
	public List<Media> readByDeleteFlag(int projectId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root media = criteriaQuery.from(Media.class);
        criteriaQuery.multiselect(media);
        CriteriaQuery result = criteriaQuery.where(criteriaBuilder.equal(media.get("project"),projectId),criteriaBuilder.equal(media.get("deleteFlag"),0));
        TypedQuery query = entityManager.createQuery(result);
        return query.getResultList();
   
	}

}
