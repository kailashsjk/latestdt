package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.MediaDTO;
import com.techm.adms.dt.entity.Media;

@Named
public class MediaConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(MediaConversation.class);
	public List<MediaDTO> fromEntityToDTO(List<Media> mediaList){
	List<MediaDTO> mediaDTOList = new ArrayList<MediaDTO>();
	if(mediaList != null && mediaList.size() >0){
		MediaDTO mediaDto = null;
		for(Media media:mediaList){
			LOGGER.debug("media>>>>>>"+media);
			mediaDto = new MediaDTO();
			mediaDto.setMediaId(media.getMediaId());
			mediaDto.setTechiniqueUsed(media.getTechiniqueUsed());
			mediaDto.setInputNotes(media.getInputNotes());
			//mediaDto.setInputNotesShort(subStringUtil.doSubstring(media.getInputNotes(),15));
			mediaDto.setJobType(media.getJobType());
			mediaDto.setUpdatedDate(media.getUpdatedDate());
			mediaDto.setDeleteFlag(media.getDeleteFlag());
			mediaDto.setIntervieweeName(media.getIntervieweeName());
			if(media.getMediaDocument()!= null && media.getMediaDocument().size() > 0){
				mediaDto.setMediaType(media.getMediaDocument().get(0).getMediaType().getMediaType());
				
			}
			LOGGER.debug("media.getPersonaDocument()>>>>>>"+media.getPersonaDocument());
			if(media.getPersonaDocument() != null ){
				mediaDto.setPersonaFlag(true);
			}
			mediaDTOList.add(mediaDto);
		}
	}
	return mediaDTOList;
	
}
}