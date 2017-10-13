package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.IdeaFeedback;
import com.techm.adms.dt.entity.PrototypeFeedback;

public interface IDTPrototypeFeedbackDAO extends IBaseDAO<PrototypeFeedback, Serializable> {

	
	public List<PrototypeFeedback> getPrototypeFeedbackByProjectId(int projectId);
	public List<PrototypeFeedback> getPrototypeFeedbackByProjectIdActiveDatas(int projectId);
	public void deletePrototypeFeedback(PrototypeFeedback prototypeFeedback) ;
}
