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
 * Entity implementation class for Entity: AssignIdeaGroup
 *
 */
@Entity
@Table(name="assignideagroup")
public class AssignIdeaGroup implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=IdeaGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "IGID", referencedColumnName = "IGID")
	private IdeaGroup ideaGroup;
	
	@ManyToOne(targetEntity=Idea.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "IdeaID", referencedColumnName = "IdeaID")
	private Idea idea;

	public IdeaGroup getIdeaGroup() {
		return ideaGroup;
	}

	public void setIdeaGroup(IdeaGroup ideaGroup) {
		this.ideaGroup = ideaGroup;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AssignIdeaGroup [id=" + id + ", ideaGroup=" + ideaGroup
				+ ", idea=" + idea + "]";
	}


	
}
