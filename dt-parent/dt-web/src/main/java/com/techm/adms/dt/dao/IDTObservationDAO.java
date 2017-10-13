package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.Observation;

public interface IDTObservationDAO extends IBaseDAO<Observation, Serializable>{

	/**
	 * Retrieve Observation entities based on projectId
	 * 
	 * @param projectId
	 * @return
	 */
	public List<Observation> getObservationsByProjectId(int projectId);
	public void deleteObservation(int observationID);
	public List<Observation> getAllObservationsByProjectId(int projectId);
	public void activateObservations(int observationID);
}
