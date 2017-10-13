package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Idea;
import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.Project;
import com.techm.adms.dt.entity.Prototype;

@Named
public class DTPrototypingDAO extends BaseDAO<Prototype, Serializable>
		implements IDTPrototypingDAO {

	@Override
	public List<Prototype> getPrototypeByProjectId(int projectId) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prototype> query = builder.createQuery(Prototype.class);
		Root<Media> media = query.from(Media.class);
		Root<Project> project = query.from(Project.class);
		Root<Prototype> ProtoType = query.from(Prototype.class);
		Root<Idea> idea = query.from(Idea.class);
		Root<HmwQuestion> hmwQuestions = query.from(HmwQuestion.class);
		TypedQuery<Prototype> typedQuery = entityManager.createQuery(query
				.select(ProtoType)
				.where(builder.and(
						builder.equal(project.get("projectId"), projectId),
						builder.equal(media.get("project"), project),
						builder.equal(hmwQuestions.get("media"), media),
						builder.equal(idea.get("hmwQuestions"), hmwQuestions),
						builder.equal(ProtoType.get("idea"), idea),
						builder.equal(ProtoType.get("deleteFlag"), 0)))
				.distinct(true));

		return typedQuery.getResultList();

	}

	@Override
	public void delete(int prototypeId) {
		Prototype protoType = read(prototypeId);
		protoType.setDeleteFlag(1);

	}

}
