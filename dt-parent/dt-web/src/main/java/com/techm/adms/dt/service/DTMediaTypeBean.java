package com.techm.adms.dt.service;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dao.IDTMediaTypeDAO;
import com.techm.adms.dt.entity.MediaType;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTMediaTypeBean implements IDTMediaTypeBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DTMediaTypeBean.class);
	
	@Inject
	IDTMediaTypeDAO dtMediaTypeDAO;
	@PersistenceContext(unitName="DesignThinking")
    protected EntityManager entityManager;
	@SuppressWarnings("unused")
	private MediaType mediaType;
	
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	/*public List<MediaType> getMediaType(int mediaId) throws DTServiceException{
		System.out.println("iN CLASS");
		Query q = entityManager.createQuery("SELECT mediaType from MediaType");
		System.out.println("oUT CLASS");
		
	 
		List<MediaType> results=q.getResultList();
		return results;
	}*/
	public List<MediaType> getMediaType() throws DTServiceException{
		return dtMediaTypeDAO.readAll();
	}
}
