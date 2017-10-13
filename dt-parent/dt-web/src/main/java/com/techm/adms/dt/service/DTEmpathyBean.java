package com.techm.adms.dt.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dao.IDTEmpathyDAO;
import com.techm.adms.dt.entity.Observation;

public class DTEmpathyBean implements IDTEmpathyBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(DTEmpathyBean.class);
	@Inject
	IDTEmpathyDAO dTEmpathyDAO;
	
	@Override
	public List<Observation> retrieveEmpathy(int mediaID) {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dTEmpathyDAO###"+ dTEmpathyDAO);
		List<Observation> empathy = dTEmpathyDAO.getEmpathyList(mediaID);
		return empathy;
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	

}
