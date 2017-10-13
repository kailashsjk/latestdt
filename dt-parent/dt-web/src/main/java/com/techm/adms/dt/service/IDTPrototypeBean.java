package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.PrototypeDTO;
import com.techm.adms.dt.entity.Prototype;



public interface IDTPrototypeBean {
	
	public void createPrototype(Prototype prototype) throws DTServiceException;
	public void upadatePrototypeDescription(Prototype prototype) throws DTServiceException;
	public List<PrototypeDTO> getPrototypeDetailByProjectId(int projectId) throws DTServiceException;
	public List<PrototypeDTO> getDTPrototypeDetailByProjectId(int projectId) throws DTServiceException;
	public void upadatePrototypeStatus(Prototype prototype) throws DTServiceException;
    public void deletePrototype(int prototypeId) throws DTServiceException;
    public void activatePrototype(int prototypeId) throws DTServiceException;
    public void upadateTest(Prototype updatedTest) throws DTServiceException;
    public Prototype getPrototypeDetailsByUniqueId(String uniqueId) throws DTServiceException;
}
