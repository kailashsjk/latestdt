package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.NeedsOrInsightsDTO;
import com.techm.adms.dt.entity.NeedsOrInsight;

public interface IDTNeedsOrInsightsBean {
	public List<NeedsOrInsightsDTO> retrieveNeeds(int projectID)throws DTServiceException;
	public List<NeedsOrInsightsDTO> retrieveInsights(int projectID)throws DTServiceException;
	public void createNeedsOrInsights(NeedsOrInsight needsOrInsight) throws DTServiceException;
	public void deactivateNeedsOrInsights(int noiId) throws DTServiceException;
	public void upadateNeedsOrInsights(NeedsOrInsight needsOrInsight) throws DTServiceException;
	public List<NeedsOrInsightsDTO> retrieveNeedsByDeleteFlag(int projectID) throws DTServiceException;
	public List<NeedsOrInsightsDTO> retrieveInsightsByDeleteFlag(int projectID) throws DTServiceException;
	public NeedsOrInsight getDetail(int noiId) throws DTServiceException;
	public void reActivateNeedsOrInsights(int noiId) throws DTServiceException;
	
}
