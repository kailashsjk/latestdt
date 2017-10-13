package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.techm.adms.dt.entity.User;

public interface IUserDAO extends IBaseDAO<User, Serializable> {
	public List<User> getUserDetailsByUserId(String userId,String password);
}
