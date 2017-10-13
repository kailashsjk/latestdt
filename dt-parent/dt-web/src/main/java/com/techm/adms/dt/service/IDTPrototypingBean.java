package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.PrototypingDTO;
import com.techm.adms.dt.entity.Prototype;


public interface IDTPrototypingBean {
	
	public void createPrototype(Prototype prototyping) throws DTServiceException;
	public void upadatePrototypeDescription(Prototype prototyping) throws DTServiceException;
	public List<PrototypingDTO> getPrototypeDetailByProjectId(int projectId) throws DTServiceException;
	public void upadatePrototypeStatus(Prototype prototyping) throws DTServiceException;
    public void deletePrototype(int prototypeId);
	
}
