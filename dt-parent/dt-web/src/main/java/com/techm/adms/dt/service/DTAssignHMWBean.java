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
import com.techm.adms.dt.dao.IDTAssignHMWDAO;
import com.techm.adms.dt.dao.IDTEmpathyHmwQuestionsDAO;
import com.techm.adms.dt.dto.AssignHMWDTO;
import com.techm.adms.dt.entity.AssignHMW;
import com.techm.adms.dt.entity.IdeaGroup;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTAssignHMWBean implements IDTAssignHMWBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(DTAssignHMWBean.class);
	@Inject
	IDTAssignHMWDAO dtAssignHMWDAO;
	@Inject
	IDTEmpathyHmwQuestionsDAO dtEmpathyHmwQuestionDAO;
	
	@Override
	public List<AssignHMW> retrieveHMW(int ideaGroupId) throws DTServiceException {
		LOGGER.info("Inside DTAssignHMWBean");
		List<AssignHMW> assignHMWList  = dtAssignHMWDAO.retrieveAssignHMWByIdeaGroupId(ideaGroupId);
		LOGGER.info("assignHMWList:::>>>"+assignHMWList);
		return assignHMWList;
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateAssignHMW(AssignHMWDTO assignHMWDTO) throws DTServiceException{
		LOGGER.info("Inside DTAssignHMWBean");
		List<AssignHMW> assignHMWs = dtAssignHMWDAO.retrieveAssignHMWByIdeaGroupId(assignHMWDTO.getIdeaGroupId());
		if(assignHMWs != null && assignHMWs.size() > 0){
			for(AssignHMW assignHMW : assignHMWs){
				dtAssignHMWDAO.delete(assignHMW);
			}
		}
		if(assignHMWDTO.getHmwList() != null && assignHMWDTO.getHmwList().length > 0){
			AssignHMW assignHMW = null;
			IdeaGroup ideaGroup =  new IdeaGroup();
			ideaGroup.setIGID(assignHMWDTO.getIdeaGroupId());
			for(String questionID : assignHMWDTO.getHmwList()){
				assignHMW = new AssignHMW();
				assignHMW.setHmwQuestion(dtEmpathyHmwQuestionDAO.read(Integer.parseInt(questionID)));
				assignHMW.setIdeaGroup(ideaGroup);
				LOGGER.info("assignIdeaGroup:::>>>>"+assignHMW);
				dtAssignHMWDAO.create(assignHMW);
			}
		}
	}
}
