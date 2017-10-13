package com.techm.adms.dt.conversation;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.entity.Prototype;

@Named
public class PrototypeConversation {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrototypeConversation.class);
	
	public List<PrototypeDTO> fromEntityToDTO(List<Prototype> prototypeing){
		List<PrototypeDTO> prototypeDTOList = new ArrayList<PrototypeDTO>();
		if(prototypeing != null && prototypeing.size() >0){
			PrototypeDTO prototypeDto = null;
			for(Prototype prototype:prototypeing){
				LOGGER.debug("prototype>>>>>>"+prototype);
				prototypeDto = new PrototypeDTO();
				prototypeDto.setIGName(prototype.getIdeaGroup().getIGName());
				//prototypeDto.setQuestionDescription(prototype.getIdeaGroup().getProject().getHmwQuestions().getQuestionDescription());
				prototypeDto.setPrototypeDescription(prototype.getPrototypeDescription());
				prototypeDto.setCreatedBy(prototype.getUser().getFirstName()+" "+prototype.getUser().getLastName());
				prototypeDto.setCreatedDate(prototype.getCreatedDate());
				prototypeDto.setIGID(prototype.getIdeaGroup().getIGID());
				prototypeDto.setPrototypeId(prototype.getPrototypeId());
				prototypeDto.setUpdatedDate(prototype.getUpdatedDate());
                prototypeDto.setDeleteFlag(prototype.getDeleteFlag());
                prototypeDto.setPrototypeStatus(prototype.getPrototypeStatus());
                prototypeDto.setTest(prototype.getTest());
                if(prototype.getPrototypeDocuments() != null && prototype.getPrototypeDocuments().size() > 0){
                	prototypeDto.setMediaFlag(true);
                }
                System.out.println(prototype.getPrototypeDescription());
				
				prototypeDTOList.add(prototypeDto);
			}
		}
		return prototypeDTOList;
		
	}
	

}
