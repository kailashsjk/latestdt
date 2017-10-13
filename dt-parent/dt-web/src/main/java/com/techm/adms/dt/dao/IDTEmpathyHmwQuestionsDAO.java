package com.techm.adms.dt.dao;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.techm.adms.dt.entity.HmwQuestion;




@ApplicationScoped
@Named
public interface IDTEmpathyHmwQuestionsDAO extends IBaseDAO<HmwQuestion, Serializable>{
	public List<HmwQuestion>getHmwQuestionsDetail(int mediaID);
	public List<Object[]> getHmwQuestionsByMediaID(int mediaID);
	public void activateHmwQuestion(HmwQuestion hmwquestion);
	public void deleteHmwQuestion(HmwQuestion hmwquestion);
	public List<HmwQuestion> getActiveHmwQuestionsDetail(int projectId);
}
