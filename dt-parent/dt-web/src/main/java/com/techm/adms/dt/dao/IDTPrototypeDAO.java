package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.Prototype;



public interface IDTPrototypeDAO extends IBaseDAO<Prototype, Serializable>{
	
	//public List<Prototype> getPrototypeByProjectId(int ideaID);
	public void delete(int prototypeId);
	public void activate(int prototypeId);
	public List<Prototype> getDTPrototypeDetailByProjectId(int ideaID);
	public List<Prototype> getPrototypeDetailByProjectId(int projectId);
	public List<Prototype> getPrototypeForPrototypeFeedback(int projectId);
	public Prototype getPrototypeDetailsByUniqueId(String uniqueId);
}
