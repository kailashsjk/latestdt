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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.PrototypingConversation;
import com.techm.adms.dt.dao.IDTPrototypingDAO;
import com.techm.adms.dt.dto.PrototypingDTO;
import com.techm.adms.dt.entity.Prototype;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTPrototypingBean implements IDTPrototypingBean {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DTPrototypingBean.class);

	@Inject
	IDTPrototypingDAO dtPrototypeDAO;
	@Inject
	PrototypingConversation prototypingConversation;

	@PersistenceContext
	protected EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPrototype(Prototype prototyping)
			throws DTServiceException {
		LOGGER.info("In Bean Class");
		try {
			LOGGER.info("In Bean Class dtPrototypeDAO###" + dtPrototypeDAO);
			dtPrototypeDAO.create(prototyping);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}

	}

	public List<PrototypingDTO> getPrototypeDetailByProjectId(int projectId)
			throws DTServiceException {
		List<Prototype> prototyping = dtPrototypeDAO
				.getPrototypeByProjectId(projectId);
		LOGGER.debug("prototyping>>>>>>" + prototyping);
		return prototypingConversation.fromEntityToDTO(prototyping);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadatePrototypeDescription(
			Prototype updatedPrototypeDescription) throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			Prototype existingPrototype = dtPrototypeDAO
					.read(updatedPrototypeDescription.getPrototypeId());
			LOGGER.debug(existingPrototype.toString() + "   1####  "
					+ existingPrototype);
			existingPrototype
					.setPrototypeDescription(updatedPrototypeDescription
							.getPrototypeDescription());
			existingPrototype.setPrototypeStatus(updatedPrototypeDescription
					.getPrototypeStatus());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			dtPrototypeDAO.update(existingPrototype);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	public void upadatePrototypeStatus(Prototype updatedPrototypeStatus)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			Prototype existingPrototype = dtPrototypeDAO
					.read(updatedPrototypeStatus.getPrototypeId());
			LOGGER.debug(existingPrototype.toString() + "   1####  "
					+ existingPrototype);
			existingPrototype.setPrototypeStatus(updatedPrototypeStatus
					.getPrototypeStatus());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			dtPrototypeDAO.update(existingPrototype);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deletePrototype(int prototypeId) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			Prototype existingPrototype = dtPrototypeDAO.read(prototypeId);

			LOGGER.debug(existingPrototype.toString() + "   1####  "
					+ existingPrototype);
			existingPrototype.setPrototypeDescription(existingPrototype
					.getPrototypeDescription());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			dtPrototypeDAO.delete(existingPrototype.getPrototypeId());
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

}
