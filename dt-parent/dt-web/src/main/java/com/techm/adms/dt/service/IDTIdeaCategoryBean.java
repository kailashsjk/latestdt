package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.IdeaCategory;



public interface IDTIdeaCategoryBean {
	public void createIdeaCategory(IdeaCategory ideaCategory) throws DTServiceException;
	public List<IdeaCategory> getAllDTIdeaCategoryDetails() throws DTServiceException;
	
}
