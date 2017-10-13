package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.NeedsOrInsight;

public class DTNeedsOrInsightsDAO extends BaseDAO<NeedsOrInsight, Serializable> implements IDTNeedsOrInsightsDAO{

	@Override
		public List<NeedsOrInsight> getNeedList(int projectID){
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<NeedsOrInsight> criteriaQuery = criteriaBuilder.createQuery(NeedsOrInsight.class);
	        Root<NeedsOrInsight> rootEntry = criteriaQuery.from(NeedsOrInsight.class);
	        criteriaQuery.select(rootEntry);
	        CriteriaQuery<NeedsOrInsight> result = criteriaQuery.where(
	        		criteriaBuilder.and(
		        			criteriaBuilder.equal(rootEntry.get("project"),projectID),
		        			criteriaBuilder.equal(rootEntry.get("needOrInsight"),"N")
		        			)
	        		);
	        TypedQuery<NeedsOrInsight> query = entityManager.createQuery(result);
	        List<NeedsOrInsight> needList= query.getResultList();
			return needList;
		}
	
	@Override
	public List<NeedsOrInsight> getNeedListByDeleteFlag(int projectID){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NeedsOrInsight> criteriaQuery = criteriaBuilder.createQuery(NeedsOrInsight.class);
        Root<NeedsOrInsight> rootEntry = criteriaQuery.from(NeedsOrInsight.class);
        criteriaQuery.select(rootEntry);
        CriteriaQuery<NeedsOrInsight> result = criteriaQuery.where(
        		criteriaBuilder.and(
	        			criteriaBuilder.equal(rootEntry.get("project"),projectID),
	        			criteriaBuilder.equal(rootEntry.get("needOrInsight"),"N"),
	        			criteriaBuilder.equal(rootEntry.get("deleteFlag"),0)
	        			)
        		);
        TypedQuery<NeedsOrInsight> query = entityManager.createQuery(result);
        List<NeedsOrInsight> needList= query.getResultList();
		return needList;
	}
	

	@Override
	public List<NeedsOrInsight> getInsightList(int projectID) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NeedsOrInsight> criteriaQuery = criteriaBuilder.createQuery(NeedsOrInsight.class);
        Root<NeedsOrInsight> rootEntry = criteriaQuery.from(NeedsOrInsight.class);
        criteriaQuery.select(rootEntry);
        CriteriaQuery<NeedsOrInsight> result = criteriaQuery.where(
        		criteriaBuilder.and(
	        			criteriaBuilder.equal(rootEntry.get("project"),projectID),
	        			criteriaBuilder.equal(rootEntry.get("needOrInsight"),"I")
	        			)
        		);
        TypedQuery<NeedsOrInsight> query = entityManager.createQuery(result);
        List<NeedsOrInsight> insightList= query.getResultList();
		return insightList;
	}
	
	@Override
	public List<NeedsOrInsight> getInsightListByDeleteFlag(int projectID) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NeedsOrInsight> criteriaQuery = criteriaBuilder.createQuery(NeedsOrInsight.class);
        Root<NeedsOrInsight> rootEntry = criteriaQuery.from(NeedsOrInsight.class);
        criteriaQuery.select(rootEntry);
        CriteriaQuery<NeedsOrInsight> result = criteriaQuery.where(
        		criteriaBuilder.and(
	        			criteriaBuilder.equal(rootEntry.get("project"),projectID),
	        			criteriaBuilder.equal(rootEntry.get("needOrInsight"),"I"),
	        			criteriaBuilder.equal(rootEntry.get("deleteFlag"),0)
	        			)
        		);
        TypedQuery<NeedsOrInsight> query = entityManager.createQuery(result);
        List<NeedsOrInsight> insightList= query.getResultList();
		return insightList;
	}
	
	@Override
	public void deActivate(int noiId) {
		NeedsOrInsight needsOrInsight = read(noiId);
		needsOrInsight.setDeleteFlag(1);
	}
	@Override
	public void activate(int noiId) {
		NeedsOrInsight needOrInsight = read(noiId);
		needOrInsight.setDeleteFlag(0);
	}
}
