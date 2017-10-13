package com.techm.adms.dt.service;

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
import com.techm.adms.dt.dao.IDTUserAuthenticationDAO;
import com.techm.adms.dt.entity.User;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTUserAuthenticationBean implements IDTUserAuthenticationBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(DTUserAuthenticationBean.class);
	@Inject
	IDTUserAuthenticationDAO dTUserAuthenticationDAO;
	
	@Override
	public User getUserDetails(String userId) throws DTServiceException{
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dtUserAuthenticationDAO###"+ dTUserAuthenticationDAO);
		User userDetails=dTUserAuthenticationDAO.getCredentials(userId);
		LOGGER.info("In Bean Class userDetails###"+ userDetails);
		return userDetails;
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void createUser(User users) {
		dTUserAuthenticationDAO.create(users);
	}

}
