package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.AssignIdeaGroupDTO;
import com.techm.adms.dt.entity.AssignIdeaGroup;

public interface IDTAssignIdeaGroupBean {
	public List<AssignIdeaGroup> retrieveAssignIdeas(int ideaGroupId) throws DTServiceException;
	public void updateAssignIdeas(AssignIdeaGroupDTO assignIdeaGroupDTO) throws DTServiceException;
}
