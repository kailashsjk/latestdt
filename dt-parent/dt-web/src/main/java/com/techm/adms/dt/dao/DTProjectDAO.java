package com.techm.adms.dt.dao;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.Project;

@Named
public class DTProjectDAO extends BaseDAO<Project, Serializable> implements IDTProjectDAO {
	@Override
	public void deActivate(int projectId) {
		Project project = read(projectId);
		project.setDeleteFlag(1);
	}
	
	@Override
	public Project getProjectBasedOnProjId(String projId){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
        Root<Project> rootEntry = criteriaQuery.from(Project.class);
        criteriaQuery.select(rootEntry);
        CriteriaQuery<Project> result = criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("projId"),projId));
        TypedQuery<Project> q = entityManager.createQuery(result);
        Project project= (Project) q.getSingleResult();
		return project;
	}	
}
	
	
