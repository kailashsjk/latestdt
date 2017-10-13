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
import com.techm.adms.dt.dao.IDTIdeaCategoryDAO;
import com.techm.adms.dt.dao.IDTProjectDAO;
import com.techm.adms.dt.entity.IdeaCategory;
import com.techm.adms.dt.entity.Project;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTIdeaCategoryBean implements IDTIdeaCategoryBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTIdeaCategoryBean.class);
	
	@Inject
	IDTIdeaCategoryDAO dtIdeaCategoryDAO;
	
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createIdeaCategory(IdeaCategory ideaCategory) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtIdeaCategoryDAO###"+ dtIdeaCategoryDAO);
			dtIdeaCategoryDAO.create(ideaCategory);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}
	
	public List<IdeaCategory> getAllDTIdeaCategoryDetails() throws DTServiceException{
		return dtIdeaCategoryDAO.readAll();
	}


}
