package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.AssignHMW;
import com.techm.adms.dt.entity.AssignIdeaGroup;
import com.techm.adms.dt.entity.IdeaGroup;

@Named
public class DTAssignHMWDAO extends BaseDAO<AssignHMW, Serializable> implements IDTAssignHMWDAO{

	@Override
	public List<AssignHMW> retrieveAssignHMWByIdeaGroupId(int ideaGroupId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		 CriteriaQuery<AssignHMW> query = builder.createQuery(AssignHMW.class);
		    Root<AssignHMW> assignHMW = query.from(AssignHMW.class);
		    Root<IdeaGroup> ideaGroup = query.from(IdeaGroup.class);
		    TypedQuery<AssignHMW> typedQuery = entityManager.createQuery(query
		    		.select(assignHMW)
		            .where(builder.and(
		            		    builder.equal(ideaGroup.get("IGID"),ideaGroupId),
			                    builder.equal(assignHMW.get("ideaGroup"), ideaGroup)
		            )).distinct(true)
		    );
		return typedQuery.getResultList();
	}

}
