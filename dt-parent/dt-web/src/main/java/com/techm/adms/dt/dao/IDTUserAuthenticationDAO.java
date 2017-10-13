package com.techm.adms.dt.dao;

import java.io.Serializable;

import com.techm.adms.dt.entity.User;

public interface IDTUserAuthenticationDAO extends IBaseDAO<User, Serializable> {
	public User getCredentials(String userId);
}
