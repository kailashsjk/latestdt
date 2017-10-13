package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.AssignIdeaGroup;

public interface IDTAssignIdeaGroupDAO extends IBaseDAO<AssignIdeaGroup, Serializable>{

	public List<AssignIdeaGroup> retrieveAssignIdeasByIdeaGroupId(int ideaGroupId);
}
