package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.IdeaFeedbackDTO;
import com.techm.adms.dt.entity.IdeaFeedback;



public interface IDTIdeaFeedbackBean {
	public void captureIdeaFeedback(IdeaFeedback ideafeedback) throws DTServiceException;
	
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetailsByProjectID(int projectId);
	public List<IdeaFeedbackDTO> getIdeaFeedbackDetailsByProjectIDActiveDatas(int projectId);
	public void deleteIdeaFeedback(int deleteIdeaFeedback) throws DTServiceException;
	
}
