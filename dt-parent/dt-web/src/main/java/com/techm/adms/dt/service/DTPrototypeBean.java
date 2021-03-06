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
import com.techm.adms.dt.conversation.PrototypeConversation;
import com.techm.adms.dt.dao.IDTPrototypeDAO;
import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Prototype;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTPrototypeBean implements IDTPrototypeBean {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DTPrototypeBean.class);

	@Inject
	IDTPrototypeDAO dtPrototypeDAO;
	@Inject
	PrototypeConversation prototypeConversation;

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPrototype(Prototype prototype) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try {
			LOGGER.info("In Bean Class dtProjectDAO###" + dtPrototypeDAO);
			dtPrototypeDAO.create(prototype);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}

	}
	
	@Override
	public List<PrototypeDTO> getPrototypeDetailByProjectId(int projectId)
			throws DTServiceException {
		List<Prototype> prototype = dtPrototypeDAO.getPrototypeDetailByProjectId(projectId);
		LOGGER.debug("prototype>>>>>>" + prototype);
		return prototypeConversation.fromEntityToDTO(prototype);

	}
	
	@Override
	public List<PrototypeDTO> getDTPrototypeDetailByProjectId(int projectId)
			throws DTServiceException {
		List<Prototype> prototype = dtPrototypeDAO
				.getDTPrototypeDetailByProjectId(projectId);
		LOGGER.debug("prototype>>>>>>" + prototype);
		return prototypeConversation.fromEntityToDTO(prototype);

	}

	@Override
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
			existingPrototype.setTest(updatedPrototypeDescription.getTest());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			dtPrototypeDAO.update(existingPrototype);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	@Override
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
	
	@Override
	public void upadateTest(Prototype updatedTest)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			Prototype existingPrototype = dtPrototypeDAO
					.read(updatedTest.getPrototypeId());
			LOGGER.debug(existingPrototype.toString() + "   1####  "
					+ existingPrototype);
			existingPrototype.setPrototypeStatus(updatedTest
					.getPrototypeStatus());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			existingPrototype.setTest(updatedTest
					.getTest());
			dtPrototypeDAO.update(existingPrototype);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	@Override
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
	
	@Override
	public void activatePrototype(int prototypeId) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			Prototype existingPrototype = dtPrototypeDAO.read(prototypeId);

			LOGGER.debug(existingPrototype.toString() + "   1####  "
					+ existingPrototype);
			existingPrototype.setPrototypeDescription(existingPrototype
					.getPrototypeDescription());
			LOGGER.debug(existingPrototype.toString() + "   2####  "
					+ existingPrototype);
			dtPrototypeDAO.activate(existingPrototype.getPrototypeId());
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	@Override
	public Prototype getPrototypeDetailsByUniqueId(String uniqueId) throws DTServiceException{
		return dtPrototypeDAO.getPrototypeDetailsByUniqueId(uniqueId);
	}

}
