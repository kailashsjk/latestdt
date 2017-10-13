package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.IdeaGroupDTO;
import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Observation;


public interface IDTIdeaGroupBean {
	
	public void createIdeaGroup(IdeaGroup ideaGroup) throws DTServiceException;

	public List<IdeaGroupDTO> getIdeaGroupDetailsByProjectID(int projectId);

	public void updateIdeaGroup(IdeaGroup updateideaGroup);

	public void deleteIdeaGroup(int IGID);

	public List<IdeaGroupDTO> getAllIdeaGroupDetailsByProjectID(int projectId);

	public void activateIdeaGroup(int iGID);

}
