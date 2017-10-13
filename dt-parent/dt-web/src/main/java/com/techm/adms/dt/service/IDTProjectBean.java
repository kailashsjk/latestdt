package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.ProjectDTO;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.ProjectStage;



public interface IDTProjectBean {
	public Project createProject(Project project) throws DTServiceException;
	public List<ProjectDTO> getAllDTProjectDetails(int userId) throws DTServiceException;
	public void upadateProject(Project project) throws DTServiceException;
	public Project getProjectDetail(int projectId) throws DTServiceException;
	public void deleteProject(int projectId) throws DTServiceException;
	public List<ProjectDTO> getActiveDTProjectDetails(int userId) throws DTServiceException;
	public void upadateProjectStage(Project updatedProject) throws DTServiceException;
	public List<ProjectStage> getProjectStages() throws DTServiceException;
	public Project getProjectBasedOnProjId(String projId) throws DTServiceException;
}
