package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.dto.PrototypeFeedbackDTO;
import com.techm.adms.dt.entity.Observation;
import com.techm.adms.dt.entity.Prototype;
import com.techm.adms.dt.entity.PrototypeFeedback;

public class PrototypeFeedbackConversation {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrototypeFeedbackConversation.class);
	
	public List<PrototypeFeedbackDTO> fromEntityToDTO(List<PrototypeFeedback> prototypeFeedbackList){
		List<PrototypeFeedbackDTO> prototypeFeedbackDTOList = new ArrayList<PrototypeFeedbackDTO>();
		if(prototypeFeedbackList != null && prototypeFeedbackList.size() >0){
			PrototypeFeedbackDTO prototypeFeedbackDto = null;
			for(PrototypeFeedback prototypeFeedback:prototypeFeedbackList){
				LOGGER.debug("prototypeFeedback>>>>>>"+prototypeFeedback);
				prototypeFeedbackDto = new PrototypeFeedbackDTO();
				prototypeFeedbackDto.setPrototypeFeedbackID(prototypeFeedback.getPrototypeFeedbackID());
				prototypeFeedbackDto.setPrototypeDescription(prototypeFeedback.getPrototypeFeedbackDescription());
				prototypeFeedbackDto.setPrototypeDescription(prototypeFeedback.getPrototype().getPrototypeDescription());
				prototypeFeedbackDto.setIdeaDescription(prototypeFeedback.getPrototype().getIdeaGroup().getIGName());			
				prototypeFeedbackDto.setCreatedBy(prototypeFeedback.getUser().getFirstName()+" "+prototypeFeedback.getUser().getLastName());
				prototypeFeedbackDto.setCreatedDate(prototypeFeedback.getCreatedDate());				
				prototypeFeedbackDto.setIdeaGroupId(prototypeFeedback.getPrototype().getIdeaGroup().getIGID());				
				prototypeFeedbackDto.setPrototypeId(prototypeFeedback.getPrototype().getPrototypeId());
				prototypeFeedbackDTOList.add(prototypeFeedbackDto);
			}
		}
		return prototypeFeedbackDTOList;
	}
	
	

	public List<PrototypeFeedbackDTO> fromEntityToDTOFeedback(List<PrototypeFeedback> prototypeFeedbackList,List<Prototype> prototypeing){
		List<PrototypeFeedbackDTO> prototypeFeedbackDTOList = new ArrayList<PrototypeFeedbackDTO>();
		if(prototypeing != null && prototypeing.size() >0){
			
			PrototypeFeedbackDTO prototypeFeedbackDto = null;
			PrototypeDTO prototypeDto = null;
			for(Prototype prototype:prototypeing){
				
				LOGGER.debug("prototypeFeedback>>>>>>"+prototype);
				
				prototypeFeedbackDto = new PrototypeFeedbackDTO();				
				
				prototypeFeedbackDto.setIGName(prototype.getIdeaGroup().getIGName());
				prototypeFeedbackDto.setPrototypeDescription(prototype.getPrototypeDescription());				
				prototypeFeedbackDto.setIGID(prototype.getIdeaGroup().getIGID());
				prototypeFeedbackDto.setPrototypeId(prototype.getPrototypeId());
				if(prototype.getPrototypeDocuments() != null && prototype.getPrototypeDocuments().size() > 0){
					prototypeFeedbackDto.setMediaFlag(true);
                }

				for(PrototypeFeedback prototypeFeedback:prototypeFeedbackList){
					LOGGER.debug("prototype>>>>>>"+prototype);
					prototypeDto = new PrototypeDTO();					
					prototypeDto.setPrototypeId(prototypeFeedback.getPrototype().getPrototypeId());					
					if(prototypeFeedbackDto.getPrototypeId()==prototypeDto.getPrototypeId()){			
						
						prototypeFeedbackDto.setPrototypeFeedbackID(prototypeFeedback.getPrototypeFeedbackID());
						prototypeFeedbackDto.setPrototypeFeedbackDescription(prototypeFeedback.getPrototypeFeedbackDescription());						
						prototypeFeedbackDto.setDeleteFlag(prototypeFeedback.getDeleteFlag());
					}

	                
				}
				prototypeFeedbackDTOList.add(prototypeFeedbackDto);
			}
		}
		return prototypeFeedbackDTOList;
	}
}
