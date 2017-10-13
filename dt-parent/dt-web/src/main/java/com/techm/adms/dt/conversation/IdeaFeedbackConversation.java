package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.IdeaFeedbackDTO;
import com.techm.adms.dt.entity.IdeaFeedback;

public class IdeaFeedbackConversation {
	
private static final Logger LOGGER = LoggerFactory.getLogger(IdeaFeedbackConversation.class);
	
	public List<IdeaFeedbackDTO> fromEntityToDTO(List<IdeaFeedback> ideaFeedbackList){
		List<IdeaFeedbackDTO> ideaFeedbackDTOList = new ArrayList<IdeaFeedbackDTO>();
		if(ideaFeedbackList != null && ideaFeedbackList.size() >0){
			IdeaFeedbackDTO ideaFeedbackDto = null;
			for(IdeaFeedback ideaFeedback:ideaFeedbackList){
				LOGGER.debug("ideaFeedback>>>>>>"+ideaFeedback);
				ideaFeedbackDto = new IdeaFeedbackDTO();
				
				ideaFeedbackDto.setIdeaFeedbackID(ideaFeedback.getIdeaFeedbackID());
				ideaFeedbackDto.setIdeaCategoryId(ideaFeedback.getIdeaCategory().getIdeaCategoryId());
				ideaFeedbackDto.setIdeaCategoryDescription(ideaFeedback.getIdeaCategory().getIdeaCategoryDescription());
				ideaFeedbackDto.setIdeaDescription(ideaFeedback.getIdea().getIdeaDescription());
				ideaFeedbackDto.setIdeaFeedbackDescription(ideaFeedback.getIdeaFeedbackDescription());
				ideaFeedbackDto.setCreatedBy(ideaFeedback.getUser().getFirstName()+" "+ideaFeedback.getUser().getLastName());
				ideaFeedbackDto.setCreatedDate(ideaFeedback.getCreatedDate());
				ideaFeedbackDto.setDeleteFlag(ideaFeedback.getDeleteFlag());
				ideaFeedbackDTOList.add(ideaFeedbackDto);
				LOGGER.info("ideaFeedbackDto from conversation::>>>"+ ideaFeedbackDto);
				LOGGER.info("ideaFeedbackDTOList::>>>"+ideaFeedbackDTOList);
			}
		}
		LOGGER.info("ideaFeedbackDTOList::>>>"+ideaFeedbackDTOList);
		return ideaFeedbackDTOList;
	}

}
