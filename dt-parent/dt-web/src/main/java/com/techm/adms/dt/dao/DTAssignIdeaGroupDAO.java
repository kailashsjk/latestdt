package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.AssignIdeaGroup;
import com.techm.adms.dt.entity.IdeaGroup;

@Named
public class DTAssignIdeaGroupDAO extends BaseDAO<AssignIdeaGroup, Serializable> implements IDTAssignIdeaGroupDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<AssignIdeaGroup> retrieveAssignIdeasByIdeaGroupId(int ideaGroupId) {
		System.out.println("In Assign idea dao Impl");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<AssignIdeaGroup> query = builder.createQuery(AssignIdeaGroup.class);
	    Root<AssignIdeaGroup> assignIdeaGroup = query.from(AssignIdeaGroup.class);
	    Root<IdeaGroup> ideaGroup = query.from(IdeaGroup.class);
	    System.out.println("In AssignIdeaGroup service query");
	    TypedQuery<AssignIdeaGroup> typedQuery = entityManager.createQuery(query
	    		.select(assignIdeaGroup)
	            .where(builder.and(
	            		    builder.equal(ideaGroup.get("IGID"),ideaGroupId),
		                    builder.equal(assignIdeaGroup.get("ideaGroup"), ideaGroup)
	            )).distinct(true)
	    );
	    return typedQuery.getResultList();
	}
}
