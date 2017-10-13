package com.techm.adms.dt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.HmwQuestionsConversation;
import com.techm.adms.dt.dao.IDTEmpathyHmwQuestionsDAO;
import com.techm.adms.dt.dto.HmwQuestionsDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Project;
@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DTEmpathyHmwQuestionsBean implements IDTEmpathyHmwQuestionsBean {
	
	
	
		
		private static final Logger LOGGER = LoggerFactory.getLogger(DTEmpathyHmwQuestionsBean.class);
		
		@Inject
		IDTEmpathyHmwQuestionsDAO dtEmpathyHmwQuestionsDAO;
		
		@Inject
		HmwQuestionsConversation hmwQuestionsConversation;
		
		
		@TransactionAttribute(TransactionAttributeType.REQUIRED)

		public void createHmwQuestions(HmwQuestion hmwQuestions)throws DTServiceException{
			LOGGER.info("In Bean Class");
			try{
				LOGGER.info("In Bean Class dtProjectDAO###"+ dtEmpathyHmwQuestionsDAO);
				dtEmpathyHmwQuestionsDAO.create(hmwQuestions);
			}catch(Exception e){
				throw new DTServiceException(e);
			}
			
	}
		
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public  void updateDTEmpathyHmwQuestions(HmwQuestion updatedHmwQuestion) throws DTServiceException{
			LOGGER.info("In Project Bean Class upadateProject method");
			try{
				HmwQuestion existingHmwQuestion = dtEmpathyHmwQuestionsDAO.read(updatedHmwQuestion.getQuestionID());
				//createdDate= existingHmwQuestion.getCreatedDate();
				LOGGER.debug("   1####  "+existingHmwQuestion);
				LOGGER.debug("   1####  "+existingHmwQuestion.toString());
				existingHmwQuestion.setQuestionDescription(updatedHmwQuestion.getQuestionDescription());
				LOGGER.debug(existingHmwQuestion.toString()+"   2####  "+existingHmwQuestion);
				dtEmpathyHmwQuestionsDAO.update(existingHmwQuestion);
			}catch(Exception e){
				throw new DTServiceException(e);
			}
		}

		@Override
		public List<HmwQuestionsDTO> getDTEmpathyHmwQuestions(int projectId)  throws DTServiceException{
		
			List<HmwQuestion> hmwQuestions = dtEmpathyHmwQuestionsDAO.getHmwQuestionsDetail(projectId);
			LOGGER.debug("hmwQuestions>>>>>>"+hmwQuestions);
			return hmwQuestionsConversation.fromEntityToDTO(hmwQuestions);
		
	}

		@Override
		public List<HmwQuestionsDTO> getActiveDTEmpathyHmwQuestions(int projectId)  throws DTServiceException{
		
			List<HmwQuestion> hmwQuestions = dtEmpathyHmwQuestionsDAO.getActiveHmwQuestionsDetail(projectId);
			LOGGER.debug("hmwQuestions>>>>>>"+hmwQuestions);
		return hmwQuestionsConversation.fromEntityToDTO(hmwQuestions);
		
	}
		
		@Override
		public List<HmwQuestion> getActiveDTEmpathyHmwQuestionsEntity(int projectId)  throws DTServiceException{
		
			List<HmwQuestion> hmwQuestions = dtEmpathyHmwQuestionsDAO.getActiveHmwQuestionsDetail(projectId);
			LOGGER.debug("hmwQuestions>>>>>>"+hmwQuestions);
		return hmwQuestions;
		
	}
			
		
	       public List<HmwQuestion> getHmwQuestionsByMediaID(int mediaID) throws DTServiceException{
	            
	        	LOGGER.info("In class");
	        	
	            List<HmwQuestion> hmqList = new ArrayList<HmwQuestion>();
	            List<Object[]> hmqListfromDAO;
                HmwQuestion hmw =  null;

	            
				try {

			     hmqListfromDAO = dtEmpathyHmwQuestionsDAO.getHmwQuestionsByMediaID(mediaID);
	            
                LOGGER.info("hmqListfromDAO size "+hmqListfromDAO.size());
	                
	                 for (Iterator iterator = hmqListfromDAO.iterator(); iterator.hasNext();)
	                  {
	                      Object obj[] = (Object[])iterator.next();
	                      hmw =  new HmwQuestion();
	                      LOGGER.info("hmqListfromDAO Print "+obj[0]);
	                      LOGGER.info("hmqListfromDAO Print "+obj[1]);
	                      LOGGER.info("hmqListfromDAO Print "+((Integer)obj[0]).intValue());
	                      LOGGER.info("hmqListfromDAO Print "+(String)obj[1]);
	                      hmw.setQuestionID(((Integer)obj[0]).intValue());
	                      hmw.setQuestionDescription((String)obj[1]);
	                      hmqList.add(hmw);
	                  }

				} catch (Exception e) {
					// TODO Auto-generated catch block
					LOGGER.info("In class"+e);
					e.printStackTrace();
					
				}
	                  
	           return hmqList;
		

		}
		

	 
	   	@Override
	   	public HmwQuestion getHmwQuestionsDetailsByQuestionId(int questionId)
	   	{
	   		LOGGER.info("In Project Bean Class upadateProject method");
	   		HmwQuestion hmwQuestion = new HmwQuestion();
			try{
				hmwQuestion = dtEmpathyHmwQuestionsDAO.read(questionId);
			}catch(Exception e){
				throw new DTServiceException(e);
			}
			return hmwQuestion;	
	   	}
	   	@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void deleteHmwQuestion(int deleteHmwQuestion) throws DTServiceException {
			LOGGER.info("In Project Bean Class deleteObservation method");
			try {
				HmwQuestion existingHmwQuestion = dtEmpathyHmwQuestionsDAO.read(deleteHmwQuestion);

				LOGGER.debug(existingHmwQuestion.toString() + "   1####  "
						+ existingHmwQuestion);
				existingHmwQuestion.setQuestionDescription(existingHmwQuestion.getQuestionDescription());
				LOGGER.debug(existingHmwQuestion.toString() + "   2####  "
						+ existingHmwQuestion);
				dtEmpathyHmwQuestionsDAO.deleteHmwQuestion(existingHmwQuestion);
			} catch (Exception e) {
				throw new DTServiceException(e);
			}
		}
	   	
	   	
		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void activateHmwQuestion(int activateHmwQuestion) throws DTServiceException {
			LOGGER.info("In Project Bean Class deleteObservation method");
			try {
				HmwQuestion existingHmwQuestion = dtEmpathyHmwQuestionsDAO.read(activateHmwQuestion);

				LOGGER.debug(existingHmwQuestion.toString() + "   1####  "
						+ existingHmwQuestion);
				existingHmwQuestion.setQuestionDescription(existingHmwQuestion.getQuestionDescription());
				LOGGER.debug(existingHmwQuestion.toString() + "   2####  "
						+ existingHmwQuestion);
				dtEmpathyHmwQuestionsDAO.activateHmwQuestion(existingHmwQuestion);
			} catch (Exception e) {
				throw new DTServiceException(e);
			}
		} 	
	   	
	}




