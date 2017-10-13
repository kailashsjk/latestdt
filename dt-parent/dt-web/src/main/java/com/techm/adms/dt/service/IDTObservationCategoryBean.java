package com.techm.adms.dt.service;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.ObservationCategory;
import com.techm.adms.dt.entity.Project;


public interface IDTObservationCategoryBean {
	public List<ObservationCategory> getObservationCategory() throws DTServiceException;


}
