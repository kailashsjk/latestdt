package com.techm.adms.dt.service;

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
import com.techm.adms.dt.conversation.IdeaGroupConversation;
import com.techm.adms.dt.dao.DTIdeaGroupDAO;
import com.techm.adms.dt.dto.IdeaGroupDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DTIdeaGroupBean implements IDTIdeaGroupBean{
	private static final Logger LOGGER = LoggerFactory.getLogger(DTProjectBean.class);
	@Inject 
	DTIdeaGroupDAO dtIdeaGroupDAO;
	
	@Inject
	IdeaGroupConversation ideaGroupConversation;
	
	@Override
	public void createIdeaGroup(IdeaGroup ideaGroup) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtIdeaGroupDAO###"+ dtIdeaGroupDAO);
			dtIdeaGroupDAO.create(ideaGroup);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<IdeaGroupDTO> getIdeaGroupDetailsByProjectID(int projectId) {
		// TODO Auto-generated method stub
		List<IdeaGroup> ideagroup = dtIdeaGroupDAO.getIdeaGroupDetailsByProjectID(projectId);
		LOGGER.debug("ideagroup>>>>>>"+ideagroup);
		return ideaGroupConversation.fromEntityToDTO(ideagroup);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<IdeaGroupDTO> getAllIdeaGroupDetailsByProjectID(int projectId) {
		// TODO Auto-generated method stub
		List<IdeaGroup> ideagroup = dtIdeaGroupDAO.getAllIdeaGroupDetailsByProjectID(projectId);
		LOGGER.debug("ideagroup>>>>>>"+ideagroup);
		return ideaGroupConversation.fromEntityToDTO(ideagroup);
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateIdeaGroup(IdeaGroup updateideaGroup) {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			IdeaGroup existingIdeaGroup = dtIdeaGroupDAO
					.read(updateideaGroup.getIGID());

			LOGGER.debug(existingIdeaGroup.toString() + "   1####  "
					+ existingIdeaGroup);
			existingIdeaGroup.setIGName(updateideaGroup
					.getIGName());
			LOGGER.debug(existingIdeaGroup.toString() + "   2####  "
					+ existingIdeaGroup);
			dtIdeaGroupDAO.update(existingIdeaGroup);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
		// TODO Auto-generated method stub
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteIdeaGroup(int IGID)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			IdeaGroup existingIdeaGroup = dtIdeaGroupDAO
					.read(IGID);

			LOGGER.debug(existingIdeaGroup.toString() + "   1####  "
					+ existingIdeaGroup);
			existingIdeaGroup.setIGName(existingIdeaGroup
					.getIGName());
			LOGGER.debug(existingIdeaGroup.toString() + "   2####  "
					+ existingIdeaGroup);
			dtIdeaGroupDAO.deleteIdeaGroup(existingIdeaGroup.getIGID());
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void activateIdeaGroup(int IGID)
				throws DTServiceException {
			LOGGER.info("In Project Bean Class deleteObservation method");
			try {
				IdeaGroup existingIdeaGroup = dtIdeaGroupDAO
						.read(IGID);

				LOGGER.debug(existingIdeaGroup.toString() + "   1####  "
						+ existingIdeaGroup);
				existingIdeaGroup.setIGName(existingIdeaGroup
						.getIGName());
				LOGGER.debug(existingIdeaGroup.toString() + "   2####  "
						+ existingIdeaGroup);
				dtIdeaGroupDAO.activateIdeaGroup(existingIdeaGroup.getIGID());
			} catch (Exception e) {
				throw new DTServiceException(e);
			}
	}
	
	
	
	}

	

	


