package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.IdeaDTO;
import com.techm.adms.dt.entity.Idea;


@Named
public class IdeaConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaConversation.class);
	public List<IdeaDTO> fromEntityToDTO(List<Idea> ideaList){
		List<IdeaDTO> ideaDTOList = new ArrayList<IdeaDTO>();
		if(ideaList != null && ideaList.size() >0){
			IdeaDTO ideaDto = null;
			for(Idea idea:ideaList){
				LOGGER.debug("ideas>>>>>>"+idea);
				ideaDto = new IdeaDTO();
				ideaDto.setIdeaId(idea.getIdeaId());
				ideaDto.setIdeaDescription(idea.getIdeaDescription());
			    ideaDto.setCreatedDate(idea.getUpdatedDate());
			    ideaDto.setProjectId(idea.getProject().getProjectId());
			    ideaDto.setCreatedBy(idea.getUser().getFirstName()+" "+idea.getUser().getLastName());
			    ideaDto.setDeleteFlag(idea.getDeleteFlag());
				//ideaDto.setFinalizeIdea(idea.getFinalizeIdea());
				ideaDTOList.add(ideaDto);
			}
		}
		return ideaDTOList;
		
	}
}
