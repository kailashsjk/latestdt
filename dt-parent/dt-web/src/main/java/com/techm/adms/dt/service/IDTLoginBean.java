package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;

import com.techm.adms.dt.entity.User;

public interface IDTLoginBean {
	
	public List<User> getUserDetails(String userId,String password) throws DTServiceException;
}
