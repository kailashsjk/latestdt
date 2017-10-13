package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import com.techm.adms.dt.entity.IdeaFeedback;


public interface IDTIdeaFeedbackDAO extends IBaseDAO<IdeaFeedback, Serializable>{
	
	public List<IdeaFeedback> getIdeaFeedbackByProjectId(int projectId);
	public List<IdeaFeedback> getIdeaFeedbackByProjectIdActiveDatas(int projectId) ;
	public void deleteIdeaFeedback(IdeaFeedback ideaFeedback);

}
