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
import com.techm.adms.dt.conversation.NeedsOrInsightsConversation;
import com.techm.adms.dt.dao.IDTNeedsOrInsightsDAO;
import com.techm.adms.dt.dto.NeedsOrInsightsDTO;
import com.techm.adms.dt.entity.NeedsOrInsight;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTNeedsOrInsightsBean implements IDTNeedsOrInsightsBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(DTNeedsOrInsightsBean.class);
	
	@Inject
	IDTNeedsOrInsightsDAO dTNeedsOrInsightsDAO;
	@Inject
	NeedsOrInsightsConversation needsOrInsightsConversation;
	
	//Retriving Needs
	@Override
	public List<NeedsOrInsightsDTO> retrieveNeeds(int projectID) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dTNeedsOrInsightsDAO###"+ dTNeedsOrInsightsDAO);
			List<NeedsOrInsight> needsList= dTNeedsOrInsightsDAO.getNeedList(projectID);
			//List<NeedsOrInsight> needsList= dTNeedsOrInsightsDAO.readAll();
			LOGGER.info("needsList::::"+ needsList);
			return needsOrInsightsConversation.fromEntityToDTO(needsList);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	//Retriving Needs By DeleteFlag
	@Override
	public List<NeedsOrInsightsDTO> retrieveNeedsByDeleteFlag(int projectID) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dTNeedsOrInsightsDAO###"+ dTNeedsOrInsightsDAO);
			List<NeedsOrInsight> needsList= dTNeedsOrInsightsDAO.getNeedListByDeleteFlag(projectID);
			//List<NeedsOrInsight> needsList= dTNeedsOrInsightsDAO.readAllByDeleteFlag();
			return needsOrInsightsConversation.fromEntityToDTO(needsList);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	

	//Retriving Insights
	@Override
	public List<NeedsOrInsightsDTO> retrieveInsights(int projectID) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dTNeedsOrInsightsDAO###"+ dTNeedsOrInsightsDAO);
			List<NeedsOrInsight> InsightsList= dTNeedsOrInsightsDAO.getInsightList(projectID);
			//List<NeedsOrInsight> InsightsList= dTNeedsOrInsightsDAO.readAll();
			return needsOrInsightsConversation.fromEntityToDTO(InsightsList);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}
	
	//Retriving Insights By DeleteFlag
	@Override
	public List<NeedsOrInsightsDTO> retrieveInsightsByDeleteFlag(int projectID) throws DTServiceException {
		LOGGER.info("In Bean Class");
		try{
			LOGGER.info("In Bean Class dTNeedsOrInsightsDAO###"+ dTNeedsOrInsightsDAO);
			List<NeedsOrInsight> InsightsList= dTNeedsOrInsightsDAO.getInsightListByDeleteFlag(projectID);
			//List<NeedsOrInsight> InsightsList= dTNeedsOrInsightsDAO.readAllByDeleteFlag();
			return needsOrInsightsConversation.fromEntityToDTO(InsightsList);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	//Creating Needs Or Insights
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void createNeedsOrInsights(NeedsOrInsight needsOrInsight) throws DTServiceException{
		LOGGER.info("In Bean Class");
		dTNeedsOrInsightsDAO.create(needsOrInsight);
	}
	
	//Deactivate
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deactivateNeedsOrInsights(int noiId) throws DTServiceException{
		LOGGER.info("In Bean Class");
		dTNeedsOrInsightsDAO.deActivate(noiId);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateNeedsOrInsights(NeedsOrInsight updatedNeedsOrInsight) throws DTServiceException{
		LOGGER.info("In NeedsInsights Bean Class upadate method");
		try{
			NeedsOrInsight existingNeedsOrInsight = dTNeedsOrInsightsDAO.read(updatedNeedsOrInsight.getNoiId());
			existingNeedsOrInsight.setDescription(updatedNeedsOrInsight.getDescription());
			dTNeedsOrInsightsDAO.update(existingNeedsOrInsight);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
	}

	@Override
	public NeedsOrInsight getDetail(int noiId) throws DTServiceException{
		NeedsOrInsight needsOrInsight = new NeedsOrInsight();
		try{
			needsOrInsight = dTNeedsOrInsightsDAO.read(noiId);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return needsOrInsight;
	}
	//Reactivate
		@Override
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public void reActivateNeedsOrInsights(int noiId) throws DTServiceException{
			LOGGER.info("In Bean Class");
			dTNeedsOrInsightsDAO.activate(noiId);
		}	
		
}










