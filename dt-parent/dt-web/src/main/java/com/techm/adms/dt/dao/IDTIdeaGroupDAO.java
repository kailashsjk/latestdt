package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Observation;


public interface IDTIdeaGroupDAO extends IBaseDAO<IdeaGroup, Serializable>{
	public List<IdeaGroup> getIdeaGroupDetailsByProjectID(int projectId);
	public List<IdeaGroup> getAllIdeaGroupDetailsByProjectID(int projectId);
	public void deleteIdeaGroup(int IGID);
	public void activateIdeaGroup(int IGID);

}
