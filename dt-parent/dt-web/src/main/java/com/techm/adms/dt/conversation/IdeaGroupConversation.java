package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.IdeaGroupDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.IdeaGroup;
import com.techm.adms.dt.entity.Observation;

@Named
public class IdeaGroupConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(IdeaGroupConversation.class);
	public List<IdeaGroupDTO> fromEntityToDTO(List<IdeaGroup> ideagroupList){
		List<IdeaGroupDTO> ideagroupDTOList = new ArrayList<IdeaGroupDTO>();
		if(ideagroupList != null && ideagroupList.size() >0){
			IdeaGroupDTO ideaGroupDTO = null;
			for(IdeaGroup ideagroup:ideagroupList){
				LOGGER.debug("observations>>>>>>"+ideagroup);
				ideaGroupDTO = new IdeaGroupDTO();
				ideaGroupDTO.setProjectId(ideagroup.getProject().getProjectId());
				ideaGroupDTO.setUpdatedDate(ideagroup.getUpdatedDate());
				ideaGroupDTO.setCreatedBy(ideagroup.getUser().getFirstName()+" "+ideagroup.getUser().getLastName());
				ideaGroupDTO.setCreatedDate(ideagroup.getCreateDate());
				ideaGroupDTO.setProtyping(ideagroup.getProtyping());
				ideaGroupDTO.setIGName(ideagroup.getIGName());
				ideaGroupDTO.setIGID(ideagroup.getIGID());
				ideaGroupDTO.setDeleteFlag(ideagroup.getDeleteFlag());
				ideaGroupDTO.setUpdatedBy(ideagroup.getUser().getFirstName()+" "+ideagroup.getUser().getLastName());
				//observationDto.setDocumentID(observation.getMedia().getMediaDocument());
				ideagroupDTOList.add(ideaGroupDTO);
			}
		}
		return ideagroupDTOList;
		
	}
}
