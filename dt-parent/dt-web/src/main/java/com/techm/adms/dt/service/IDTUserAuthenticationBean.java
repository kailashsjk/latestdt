package com.techm.adms.dt.service;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.User;

public interface IDTUserAuthenticationBean {
	public User getUserDetails(String userId) throws DTServiceException;
	public void createUser(User users) throws DTServiceException;
}
