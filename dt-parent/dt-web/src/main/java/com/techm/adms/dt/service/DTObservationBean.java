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
import com.techm.adms.dt.conversation.ObservationConversation;
import com.techm.adms.dt.dao.IDTObservationDAO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.Observation;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTObservationBean implements IDTObservationBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DTObservationBean.class);

	@Inject
	IDTObservationDAO dtObservationsDAO;
	
	@Inject
	ObservationConversation observationConversation;
	/**
	 * Create Observation
	 * 
	 * @param observation
	 *            - Observation Object
	 * 
	 *            return void
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createObservations(Observation observation) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try {
			LOGGER.info("In Bean Class dtProjectDAO###" + dtObservationsDAO);
			dtObservationsDAO.create(observation);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}

	}

	/**
	 * Update Observation
	 * 
	 * @param updateObservation
	 *            - updated object of the Observation Content
	 * @return void
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateObservation(Observation updateObservation)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			Observation existingObservation = dtObservationsDAO
					.read(updateObservation.getObservationID());

			LOGGER.debug(existingObservation.toString() + "   1####  "
					+ existingObservation);
			existingObservation.setObservationNotes(updateObservation
					.getObservationNotes());
			existingObservation.setObservationCategory(updateObservation.getObservationCategory());
			LOGGER.debug(existingObservation.toString() + "   2####  "
					+ existingObservation);
			dtObservationsDAO.update(existingObservation);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	/**
	 * It retrieves the Observation details
	 * @return list of Observation data
	 */
	@Override
	public List<ObservationDTO> getObservationsDetails() {
		List<Observation> observations = dtObservationsDAO.readAll();
		LOGGER.debug("observations>>>>>>"+observations);
		return observationConversation.fromEntityToDTO(observations);
	}

	/**
	 * It retrieves the Observation details
	 * @return list of Observation data
	 */
	@Override
	public List<ObservationDTO> getObservationsDetailsByProjectID(int projectId) {
		List<Observation> observations = dtObservationsDAO.getObservationsByProjectId(projectId);
		LOGGER.debug("observations>>>>>>"+observations);
		return observationConversation.fromEntityToDTO(observations);
	}
	
	/*
	 * delete observation
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteObservation(int observationID)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			Observation existingObservation = dtObservationsDAO
					.read(observationID);

			LOGGER.debug(existingObservation.toString() + "   1####  "
					+ existingObservation);
			existingObservation.setObservationNotes(existingObservation
					.getObservationNotes());
			LOGGER.debug(existingObservation.toString() + "   2####  "
					+ existingObservation);
			dtObservationsDAO.deleteObservation(existingObservation.getObservationID());
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	@Override
	public List<ObservationDTO> getAllObservationsDetailsByProjectID(int projectId) {
		List<Observation> observations = dtObservationsDAO.getAllObservationsByProjectId(projectId);
		LOGGER.debug("observations>>>>>>"+observations);
		return observationConversation.fromEntityToDTO(observations);
	}
	
	@Override
	public List<Observation> getActiveDTObservationDetails() throws DTServiceException{
		return dtObservationsDAO.readAllByDeleteFlag();
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void activateObservations(int observationID)
			throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			Observation existingObservation = dtObservationsDAO
					.read(observationID);

			LOGGER.debug(existingObservation.toString() + "   1####  "
					+ existingObservation);
			existingObservation.setObservationNotes(existingObservation
					.getObservationNotes());
			LOGGER.debug(existingObservation.toString() + "   2####  "
					+ existingObservation);
			dtObservationsDAO.activateObservations(existingObservation.getObservationID());
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	
}
