package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.Observation;

@Named
public class ObservationConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservationConversation.class);
	public List<ObservationDTO> fromEntityToDTO(List<Observation> observationList){
		List<ObservationDTO> observationDTOList = new ArrayList<ObservationDTO>();
		if(observationList != null && observationList.size() >0){
			ObservationDTO observationDto = null;
			for(Observation observation:observationList){
				LOGGER.debug("observations>>>>>>"+observation);
				observationDto = new ObservationDTO();
				observationDto.setObservationID(observation.getObservationID());
				observationDto.setObservationNotes(observation.getObservationNotes());
				observationDto.setObservationCategoryID(observation.getObservationCategory().getObservationCategoryID());
				observationDto.setCategoryDescription(observation.getObservationCategory().getCategoryDescription());
				observationDto.setIntervieweeName(observation.getMedia().getIntervieweeName());
				observationDto.setMediaInputs(observation.getMedia().getInputNotes());
				observationDto.setJobType(observation.getMedia().getJobType());
				/*if(observation.getMedia().getMediaDocument() != null){
					observationDto.setMediaType(observation.getMedia().getMediaDocument().getMediaType().getMediaType());
					observationDto.setMediaName(observation.getMedia().getMediaDocument().getMediaName());
				}*/
				observationDto.setCreatedBy(observation.getUser().getFirstName()+" "+observation.getUser().getLastName());
				observationDto.setCreatedDate(observation.getCreatedDate());
				observationDto.setUpdatedDate(observation.getUpdatedDate());
				observationDto.setDeleteFlag(observation.getDeleteFlag());
			
				observationDto.setUpdatedBy(observation.getUser().getFirstName()+" "+observation.getUser().getLastName());
				//observationDto.setDocumentID(observation.getMedia().getMediaDocument());
				observationDTOList.add(observationDto);
			}
		}
		return observationDTOList;
		
	}
}
