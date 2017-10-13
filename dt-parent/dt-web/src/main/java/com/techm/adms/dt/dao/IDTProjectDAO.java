package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.Project;


public interface IDTProjectDAO extends IBaseDAO<Project, Serializable>{
	public void deActivate(int projectId) ;
	public Project getProjectBasedOnProjId(String projId);
}
