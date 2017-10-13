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

import com.techm.adms.dt.dao.IDTAssignIdeaGroupDAO;
import com.techm.adms.dt.dao.IDTIdeaDAO;
import com.techm.adms.dt.dto.AssignIdeaGroupDTO;
import com.techm.adms.dt.entity.AssignIdeaGroup;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.IdeaGroup;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTAssignIdeaGroupBean implements IDTAssignIdeaGroupBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTAssignIdeaGroupBean.class);
	@Inject
	IDTAssignIdeaGroupDAO dtAssignIdeaGroupDAO;
	@Inject
	IDTIdeaDAO dtIdeaDAO;
	
	@Override
	public List<AssignIdeaGroup> retrieveAssignIdeas(int ideaGroupId){
		LOGGER.info("Inside DTAssignIdeaGroupBean");
		List<AssignIdeaGroup> assignIdeaGroupList  = dtAssignIdeaGroupDAO.retrieveAssignIdeasByIdeaGroupId(ideaGroupId);
		return assignIdeaGroupList;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateAssignIdeas(AssignIdeaGroupDTO assignIdeaGroupDTO){
		LOGGER.info("Inside DTAssignIdeaGroupBean");
		List<AssignIdeaGroup> assignIdeaGroups = dtAssignIdeaGroupDAO.retrieveAssignIdeasByIdeaGroupId(assignIdeaGroupDTO.getIdeaGroupId());
		LOGGER.info("assignIdeaGroupDTO.getIdeaGroupId():::>>>"+assignIdeaGroupDTO.getIdeaGroupId());
		LOGGER.info("assignIdeaGroups:::>>>>"+assignIdeaGroups);
		if(assignIdeaGroups != null && assignIdeaGroups.size() > 0){
			for(AssignIdeaGroup assignIdeaGroup : assignIdeaGroups){
				dtAssignIdeaGroupDAO.delete(assignIdeaGroup);
			}
		}
		if(assignIdeaGroupDTO.getIdeaList() != null && assignIdeaGroupDTO.getIdeaList().length > 0){
			AssignIdeaGroup assignIdeaGroup = null;
			IdeaGroup ideaGroup =  new IdeaGroup();
			ideaGroup.setIGID(assignIdeaGroupDTO.getIdeaGroupId());
			for(String ideaId : assignIdeaGroupDTO.getIdeaList()){
				assignIdeaGroup = new AssignIdeaGroup();
				assignIdeaGroup.setIdea(dtIdeaDAO.read(Integer.parseInt(ideaId)));
				assignIdeaGroup.setIdeaGroup(ideaGroup);
				LOGGER.info("assignIdeaGroup:::>>>>"+assignIdeaGroup);
				dtAssignIdeaGroupDAO.create(assignIdeaGroup);
			}
		}
	}
}
