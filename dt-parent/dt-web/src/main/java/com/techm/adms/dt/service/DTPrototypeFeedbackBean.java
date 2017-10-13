package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;









import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.PrototypeFeedbackConversation;
import com.techm.adms.dt.dao.IDTPrototypeDAO;
import com.techm.adms.dt.dao.IDTPrototypeFeedbackDAO;
import com.techm.adms.dt.dto.IdeaFeedbackDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.dto.PrototypeFeedbackDTO;
import com.techm.adms.dt.entity.IdeaFeedback;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.PrototypeFeedback;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTPrototypeFeedbackBean implements IDTPrototypeFeedbackBean {

private static final Logger LOGGER = LoggerFactory.getLogger(DTPrototypeFeedbackBean.class);
	
	@Inject
	IDTPrototypeFeedbackDAO dtPrototypeFeedbackDAO;
	@Inject
	IDTPrototypeDAO dtPrototypeDAO;
	@Inject
	PrototypeFeedbackConversation prototypeFeedbackConversation;
	
	@PersistenceContext
    protected EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPrototypeFeedback(PrototypeFeedback prototypeFeedback) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtPrototypeFeedbackDAO###"+ dtPrototypeFeedbackDAO);
			dtPrototypeFeedbackDAO.create(prototypeFeedback);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}

	@Override

	public List<PrototypeFeedbackDTO> getPrototypeFeedbackDetailsByProjectID(int projectId){
		
		List<PrototypeFeedback> prototypeFeedback=dtPrototypeFeedbackDAO.getPrototypeFeedbackByProjectId(projectId);
		LOGGER.debug("prototypeFeedback>>>>>>"+prototypeFeedback);
		return prototypeFeedbackConversation.fromEntityToDTO(prototypeFeedback);
	}

	@Override

	public List<PrototypeFeedbackDTO> getPrototypeFeedbackAndPrototype(int projectId){
		List<Prototype> prototype = dtPrototypeDAO.getPrototypeForPrototypeFeedback(projectId);
		List<PrototypeFeedback> prototypeFeedback=dtPrototypeFeedbackDAO.getPrototypeFeedbackByProjectId(projectId);
		LOGGER.debug("prototypeFeedback>>>>>>"+prototypeFeedback);
		LOGGER.debug("prototype>>>>>>"+prototype);
		return prototypeFeedbackConversation.fromEntityToDTOFeedback(prototypeFeedback,prototype);
	}
	
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deletePrototypeFeedback(int deletePrototypeFeedback) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			PrototypeFeedback existingPrototypeFeedback = dtPrototypeFeedbackDAO.read(deletePrototypeFeedback);

			LOGGER.debug(existingPrototypeFeedback.toString() + "   1####  "
					+ existingPrototypeFeedback);
			existingPrototypeFeedback.setPrototypeFeedbackDescription(existingPrototypeFeedback.getPrototypeFeedbackDescription());
			LOGGER.debug(existingPrototypeFeedback.toString() + "   2####  "
					+ existingPrototypeFeedback);
			dtPrototypeFeedbackDAO.deletePrototypeFeedback(existingPrototypeFeedback);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	

	
}
