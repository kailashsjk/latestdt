package com.techm.adms.dt.service;
import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.Observation;

public interface IDTObservationBean {
	/**
	 * It creates the Observation data into database
	 * 
	 * @param observations
	 * @throws DTServiceException
	 */
	public void createObservations(Observation observations) throws DTServiceException;
	
	/**
	 * It retrieves the Observation details
	 * 
	 * @return list of Observations
	 */
	List<ObservationDTO> getObservationsDetails();
	
	/**
	 * It updates the modified data into Observation data
	 * 
	 * @param updateObservation
	 */
	public void upadateObservation(Observation updateObservation);
	
	/**
	 * Get Observation details based on the projectID
	 * 
	 * @param projectId
	 * @return
	 */
	public List<ObservationDTO> getObservationsDetailsByProjectID(int projectId);

	public void deleteObservation(int observationID);

	public List<ObservationDTO> getAllObservationsDetailsByProjectID(int projectId);
	
	public List<Observation> getActiveDTObservationDetails() throws DTServiceException;

	public void activateObservations(int observationID);
}
