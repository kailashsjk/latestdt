package com.techm.adms.dt.conversation;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.PrototypingDTO;
import com.techm.adms.dt.entity.Prototype;
@Named
public class PrototypingConversation {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrototypingConversation.class);
	public List<PrototypingDTO> fromEntityToDTO(List<Prototype> prototypingList){
		List<PrototypingDTO> prototypingDTOList = new ArrayList<PrototypingDTO>();
		if(prototypingList != null && prototypingList.size() >0){
			PrototypingDTO prototypingDto = null;
			for(Prototype prototyping:prototypingList){
				LOGGER.debug("prototyping>>>>>>"+prototyping);
				prototypingDto = new PrototypingDTO();
				prototypingDto.setIdeaDescription(prototyping.getIdeaGroup().getIGName());
				//prototypingDto.setQuestionDescription(prototyping.getIdea().getHmwQuestions().getQuestionDescription());
				prototypingDto.setPrototypeDescription(prototyping.getPrototypeDescription());
				prototypingDto.setCreatedBy(prototyping.getUser().getFirstName()+" "+prototyping.getUser().getLastName());
				prototypingDto.setCreatedDate(prototyping.getCreatedDate());
				prototypingDto.setIdeaId(prototyping.getIdeaGroup().getIGID());
				prototypingDto.setPrototypeId(prototyping.getPrototypeId());
				prototypingDTOList.add(prototypingDto);
			}
		}
		return prototypingDTOList;
		
	}

}
