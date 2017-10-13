package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.HmwQuestionsConversation;

import com.techm.adms.dt.dao.IDTEmpathyHmwQuestionsDAO;

import com.techm.adms.dt.dao.IUserDAO;

import com.techm.adms.dt.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTLoginBean implements IDTLoginBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTEmpathyHmwQuestionsBean.class);
	
	@Inject
	IUserDAO userDAO;
	
	/*@Inject
	LoginConversation loginConversation;*/
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public List<User> getUserDetails(String userId, String password) throws DTServiceException{
		
		List<User> userList = userDAO.getUserDetailsByUserId(userId,password);
		
			LOGGER.debug("hmwQuestions>>>>>>"+userList);
			//return loginConversation.fromEntityToDTO(userList);
		return userList;
			
	}  	
}
