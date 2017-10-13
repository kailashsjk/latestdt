package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.HmwQuestionsDTO;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Project;



public interface IDTEmpathyHmwQuestionsBean {
	public void createHmwQuestions(HmwQuestion hmwQuestions) throws DTServiceException;
	public void updateDTEmpathyHmwQuestions(HmwQuestion hmwQuestions) throws DTServiceException;
	public List<HmwQuestionsDTO> getDTEmpathyHmwQuestions(int projectId) throws DTServiceException;
	public void deleteHmwQuestion(int questionID) throws DTServiceException;
	public List<HmwQuestion> getHmwQuestionsByMediaID(int mediaID) throws DTServiceException;
	public List<HmwQuestionsDTO> getActiveDTEmpathyHmwQuestions(int projectId)  throws DTServiceException;
	public HmwQuestion getHmwQuestionsDetailsByQuestionId(int questionId);
	public void activateHmwQuestion(int activateHmwQuestion) throws DTServiceException;
	public List<HmwQuestion> getActiveDTEmpathyHmwQuestionsEntity(int projectId) throws DTServiceException;
	
}
