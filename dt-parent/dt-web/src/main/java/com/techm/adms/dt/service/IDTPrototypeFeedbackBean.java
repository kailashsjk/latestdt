package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.PrototypeFeedbackDTO;
import com.techm.adms.dt.entity.PrototypeFeedback;

@Local
@Stateless
/*@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)*/
public interface IDTPrototypeFeedbackBean {

	public void createPrototypeFeedback(PrototypeFeedback prototypeFeedback) throws DTServiceException;
	
	public List<PrototypeFeedbackDTO> getPrototypeFeedbackDetailsByProjectID(int projectId);
	
	public void deletePrototypeFeedback(int deletePrototypeFeedback) throws DTServiceException;
	public List<PrototypeFeedbackDTO> getPrototypeFeedbackAndPrototype(int projectId);
	//public List<PrototypeFeedbackDTO> getPrototypeAndPrototypeFeedbackDetailsByProjectIDActiveDatas(int projectId);
}
