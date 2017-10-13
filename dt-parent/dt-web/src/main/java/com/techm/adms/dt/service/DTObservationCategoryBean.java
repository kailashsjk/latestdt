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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dao.IDTObservationCategoryDAO;
import com.techm.adms.dt.entity.ObservationCategory;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTObservationCategoryBean implements IDTObservationCategoryBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(DTProjectBean.class);
	
	@Inject
	IDTObservationCategoryDAO dtObservationCategoryDAO;	
	@PersistenceContext(unitName="DesignThinking")
    protected EntityManager entityManager;
	@SuppressWarnings("unused")
	private ObservationCategory observationCategory;
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public List<ObservationCategory> getObservationCategory() throws DTServiceException{
			return dtObservationCategoryDAO.readAll();
		}

}
