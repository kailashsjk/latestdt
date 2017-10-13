package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.Empathy;
import com.techm.adms.dt.entity.Observation;

public interface IDTEmpathyDAO extends IBaseDAO<Observation, Serializable>{

	public List<Observation> getEmpathyList(int mediaId);
}
