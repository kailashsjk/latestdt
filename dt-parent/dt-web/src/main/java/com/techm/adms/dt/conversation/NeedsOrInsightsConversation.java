package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.NeedsOrInsightsDTO;
import com.techm.adms.dt.entity.NeedsOrInsight;

public class NeedsOrInsightsConversation {
	private static final Logger LOGGER = LoggerFactory.getLogger(NeedsOrInsightsConversation.class);
	public List<NeedsOrInsightsDTO> fromEntityToDTO(List<NeedsOrInsight> noiList){
		List<NeedsOrInsightsDTO> observationDTOList = new ArrayList<NeedsOrInsightsDTO>();
		NeedsOrInsightsDTO needsOrInsightsDto= null;
		if(noiList != null && noiList.size() > 0){
			for(NeedsOrInsight needsOrInsight : noiList){
				needsOrInsightsDto= new NeedsOrInsightsDTO();
				needsOrInsightsDto.setDescription(needsOrInsight.getDescription());
				needsOrInsightsDto.setNoiId(needsOrInsight.getNoiId());
				needsOrInsightsDto.setDeleteFlag(needsOrInsight.getDeleteFlag());
				needsOrInsightsDto.setNeedOrInsight(needsOrInsight.getNeedOrInsight());
				observationDTOList.add(needsOrInsightsDto);
			}
		}
		return observationDTOList;
	}
}
