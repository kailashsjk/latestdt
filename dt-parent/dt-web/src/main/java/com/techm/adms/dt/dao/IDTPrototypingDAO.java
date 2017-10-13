package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.Prototype;


public interface IDTPrototypingDAO extends IBaseDAO<Prototype, Serializable>{
	
	public List<Prototype> getPrototypeByProjectId(int ideaID);
	public void delete(int prototypeId);
}
