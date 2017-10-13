package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.AssignHMWDTO;
import com.techm.adms.dt.entity.AssignHMW;

public interface IDTAssignHMWBean {
	public List<AssignHMW> retrieveHMW(int ideaGroupId) throws DTServiceException;

	public void updateAssignHMW(AssignHMWDTO assignHMWDTO) throws DTServiceException;
}
