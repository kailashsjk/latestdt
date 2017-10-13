package com.techm.adms.dt.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.ProjectConversation;
import com.techm.adms.dt.dao.IDTAssignedRolesDAO;
import com.techm.adms.dt.dao.IDTProjectDAO;
import com.techm.adms.dt.dao.IDTProjectStageDAO;
import com.techm.adms.dt.dto.ProjectDTO;
import com.techm.adms.dt.entity.AssignRoles;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.ProjectStage;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTProjectBean implements IDTProjectBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTProjectBean.class);
	
	@Inject
	IDTProjectDAO dtProjectDAO;
	@Inject
	ProjectConversation projectConversation;
	@Inject
	IDTAssignedRolesDAO dtAssignedRolesDAO;
	@Inject
	IDTProjectStageDAO dtProjectStageDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Project createProject(Project project) throws DTServiceException{
		LOGGER.info("In Bean Class");
		Project newProject= null;
		try{
			LOGGER.info("In Bean Class dtProjectDAO###"+ dtProjectDAO);
			newProject=dtProjectDAO.create(project);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return newProject;
	}
	@Override
	// All Projects and ASSIGNED ROLES BASED ON USERID
	public List<ProjectDTO> getAllDTProjectDetails(int userId) throws DTServiceException{
		List<AssignRoles> userswithroles = dtAssignedRolesDAO.getUserRolesbyUserId(userId);
		List<Project> projectList= dtProjectDAO.readAll();
		return projectConversation.fromEntityToDTO3(userswithroles, projectList);
	}
	@Override
	// Active Projects and ASSIGNED ROLES BASED ON USERID
	public List<ProjectDTO> getActiveDTProjectDetails(int userId) throws DTServiceException{
		List<AssignRoles> userswithroles = dtAssignedRolesDAO.getUserRolesbyUserId(userId);
		List<Project> projectList= dtProjectDAO.readAllByDeleteFlag();
		return projectConversation.fromEntityToDTO3(userswithroles, projectList);
	}
	
	/**
	 * 
	 * @param project
	 * @throws DTServiceException
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateProject(Project updatedProject) throws DTServiceException{
		LOGGER.info("In Project Bean Class upadateProject method");
		try{
			Project existingProject = dtProjectDAO.read(updatedProject.getProjectId());
			
			LOGGER.debug(existingProject.toString()+"   1####  "+existingProject);
			existingProject.setProjectName(updatedProject.getProjectName());
			existingProject.setResearchAgenda(updatedProject.getResearchAgenda());
			existingProject.setIbuName(updatedProject.getIbuName());
			existingProject.setAccountName(updatedProject.getAccountName());
			LOGGER.debug(existingProject.toString()+"   2####  "+existingProject);
			dtProjectDAO.update(existingProject);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	/**
	 * 
	 * @param project
	 * @throws DTServiceException
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateProjectStage(Project updatedProject) throws DTServiceException{
		LOGGER.info("In Project Bean Class upadateProject method");
		try{
			Project existingProject = dtProjectDAO.read(updatedProject.getProjectId());
			
			LOGGER.debug(existingProject.toString()+"   1####  "+existingProject);
			existingProject.setProjectStage(updatedProject.getProjectStage());
			LOGGER.debug(existingProject.toString()+"   2####  "+existingProject);
			dtProjectDAO.update(existingProject);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	@Override
	public Project getProjectDetail(int projectId) throws DTServiceException{
		LOGGER.info("In Project Bean Class upadateProject method");
		Project project = new Project();
		try{
			project = dtProjectDAO.read(projectId);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return project;
	}
	
	@Override
	public void deleteProject(int projectId) throws DTServiceException{
		dtProjectDAO.deActivate(projectId);
	}
	
	@Override
	public List<ProjectStage> getProjectStages() throws DTServiceException{
		List<ProjectStage> projectStages = new ArrayList<ProjectStage>();
		projectStages = dtProjectStageDAO.readAll();
		return projectStages;
	}
	
	@Override
	public Project getProjectBasedOnProjId(String projId) throws DTServiceException{
		return dtProjectDAO.getProjectBasedOnProjId(projId);
	}
}
