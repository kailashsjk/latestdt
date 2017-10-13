package com.techm.adms.dt.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.MediaType;


public interface IDTMediaTypeBean {
	public List<MediaType> getMediaType() throws DTServiceException;

}
