package com.techm.adms.dt.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AssignHMW
 *
 */
@Entity
@Table(name="assignhmw")
public class AssignHMW implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=IdeaGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "IGID", referencedColumnName = "IGID")
	private IdeaGroup ideaGroup;
	
	@ManyToOne(targetEntity=HmwQuestion.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
	private HmwQuestion hmwQuestion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IdeaGroup getIdeaGroup() {
		return ideaGroup;
	}

	public void setIdeaGroup(IdeaGroup ideaGroup) {
		this.ideaGroup = ideaGroup;
	}

	public HmwQuestion getHmwQuestion() {
		return hmwQuestion;
	}

	public void setHmwQuestion(HmwQuestion hmwQuestion) {
		this.hmwQuestion = hmwQuestion;
	}

	@Override
	public String toString() {
		return "AssignHMW [id=" + id + ", ideaGroup="
				+ ideaGroup + ", hmwQuestion=" + hmwQuestion + "]";
	}
}
