package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.AssignHMW;

public interface IDTAssignHMWDAO extends IBaseDAO<AssignHMW, Serializable>{
	public List<AssignHMW> retrieveAssignHMWByIdeaGroupId(int ideaGroupId);
}
