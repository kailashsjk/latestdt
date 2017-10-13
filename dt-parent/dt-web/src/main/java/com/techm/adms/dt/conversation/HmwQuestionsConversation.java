package com.techm.adms.dt.conversation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.dto.HmwQuestionsDTO;
import com.techm.adms.dt.dto.ObservationDTO;
import com.techm.adms.dt.entity.HmwQuestion;
import com.techm.adms.dt.entity.Observation;
@Named
public class HmwQuestionsConversation {

	
		private static final Logger LOGGER = LoggerFactory.getLogger(HmwQuestionsConversation.class);
		public List<HmwQuestionsDTO> fromEntityToDTO(List<HmwQuestion> HmwQuestionList)
		{
			List<HmwQuestionsDTO> hmwQuestionDTOList = new ArrayList<HmwQuestionsDTO>();
			
			if(HmwQuestionList != null && HmwQuestionList.size() >0){
				System.out.println("HmwQuestionList: "+HmwQuestionList);
				HmwQuestionsDTO hmwQuestionsDto = null;
				for(HmwQuestion hmwQuestion:HmwQuestionList){
					LOGGER.debug("hmwQuestion>>>>>>"+hmwQuestion);
					hmwQuestionsDto = new HmwQuestionsDTO();
					hmwQuestionsDto.setQuestionID(hmwQuestion.getQuestionID());
					hmwQuestionsDto.setProjectId(hmwQuestion.getProject().getProjectId());
					hmwQuestionsDto.setQuestionDescription(hmwQuestion.getQuestionDescription());
					hmwQuestionsDto.setCreatedBy(hmwQuestion.getUser().getFirstName()+" "+hmwQuestion.getUser().getLastName());
					hmwQuestionsDto.setCreatedDate(hmwQuestion.getCreatedDate());
					hmwQuestionsDto.setDeleteFlag(hmwQuestion.getDeleteFlag());
					hmwQuestionDTOList.add(hmwQuestionsDto);
				}
			}	
			return hmwQuestionDTOList;
			
		}
	}
		

