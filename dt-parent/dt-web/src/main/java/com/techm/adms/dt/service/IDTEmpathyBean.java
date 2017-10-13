package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.Observation;

public interface IDTEmpathyBean {
public List<Observation> retrieveEmpathy(int mediaID)throws DTServiceException;
}
